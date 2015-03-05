���ҡ�
anorm.SqlParser._ �Ѿ��������ˣ�����spring jdbctemplate�����������һ�¡�
�и����˶�����ֶ� mysql tinyint(1)��anorm��Booleanȡֵ������jdbc����int
������ǣ�booleanֻ��0��1��jdbcȡ������������-128��127

������
``` scala
DB.withConnection { implicit conn =>
  val query = SQL"select * from csw_feedback_track as f left outer join csw_feedback_reply as r on f.uuid = r.feedback_id where  (r.feedback_id is null) and (f.cascaded_reply = 0) order by f.createTime desc limit $offset,$count"
  val rs = query.executeQuery().resultSet

  val feedbacks = new ListBuffer[Feedback]
  while (rs.next()) {
    val feedback = Feedback(rs.getLong(1), rs.getLong(2), rs.getString(3), rs.getString(4), rs.getLong(5))
    feedbacks.append(feedback)
  }
  feedbacks
}
``` 
