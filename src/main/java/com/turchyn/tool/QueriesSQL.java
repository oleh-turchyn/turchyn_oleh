package com.turchyn.tool;

public enum QueriesSQL {
    INSERT_TOURS_SQL("INSERT INTO tours" + "  (title, location, transport, nutrition, duration, price) VALUES " +
            " (?, ?, ?, ?, ?, ?);"),
    SELECT_TOUR_BY_ID("select * from tours where id=?"),
    SELECT_ALL_TOURS("select * from tours"),
    DELETE_TOURS_SQL("delete from tours where id=?"),
    UPDATE_TOURS_SQL("update tours set title = ?, location = ?, transport = ?, nutrition = ?, duration = ?, price = ? where id = ?;");
    private  String query;

    QueriesSQL(String q) {
        this.query = q;
    }
    public  String getQuery(){
        return query;
    }


}
