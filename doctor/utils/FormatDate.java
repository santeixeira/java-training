package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDate {
  public Date sqlToUtil(java.sql.Date date) {
    long millis = System.currentTimeMillis();
    java.sql.Date sqlDate = new java.sql.Date(millis);
    java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    final String stringDate = sdf.format(utilDate);
    return utilDate;
  }
}
