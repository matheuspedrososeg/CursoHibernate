package com.curso.data.entities;

import javax.persistence.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "TIME_TEST")
public class TimeTest {
    // bah
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIME_TEST_ID")
    private long timeTestID;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATETIME_COLUMN")
    private Date dateTimeColumn;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TIMESTAMP_COLUMN")
    private Date timeStampColumn;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_COLUMN")
    private Date dateColumn;
    @Temporal(TemporalType.TIME)
    @Column(name = "TIME_COLUMN")
    private Date timeColumn;
    @Column(name = "SQL_DATETIME_COLUMN")
    private Timestamp sqlDatetimeColumn;
    @Column(name = "SQL_TIMESTAMP_COLUMN")
    private Timestamp sqlTimestampColumn;
    @Column(name = "SQL_DATE_COLUMN")
    private java.sql.Date sqlDateColumn;
    @Column(name = "SQL_TIME_COLUMN")
    private Time sqlTimeColumn;

    public TimeTest() {

    }

    public TimeTest(Date date) {
        this.dateTimeColumn = dateTimeColumn;
        this.timeStampColumn = timeStampColumn;
        this.dateColumn = dateColumn;
        this.timeColumn = timeColumn;

        this.sqlDatetimeColumn = new Timestamp(date.getTime());
        this.sqlTimestampColumn = new Timestamp(date.getTime());
        this.sqlDateColumn = new java.sql.Date(date.getTime());
        this.sqlTimeColumn = new Time(date.getTime());
    }

    public long getTimeTestID() {
        return timeTestID;
    }

    public void setTimeTestID(long timeTestID) {
        this.timeTestID = timeTestID;
    }

    public Date getDateTimeColumn() {
        return dateTimeColumn;
    }

    public void setDateTimeColumn(Date dateTimeColumn) {
        this.dateTimeColumn = dateTimeColumn;
    }

    public Date getTimeStampColumn() {
        return timeStampColumn;
    }

    public void setTimeStampColumn(Date timeStampColumn) {
        this.timeStampColumn = timeStampColumn;
    }

    public Date getDateColumn() {
        return dateColumn;
    }

    public void setDateColumn(Date dateColumn) {
        this.dateColumn = dateColumn;
    }

    public Date getTimeColumn() {
        return timeColumn;
    }

    public void setTimeColumn(Date timeColumn) {
        this.timeColumn = timeColumn;
    }

    public Timestamp getSqlDatetimeColumn() {
        return sqlDatetimeColumn;
    }

    public void setSqlDatetimeColumn(Timestamp sqlDatetimeColumn) {
        this.sqlDatetimeColumn = sqlDatetimeColumn;
    }

    public Timestamp getSqlTimestampColumn() {
        return sqlTimestampColumn;
    }

    public void setSqlTimestampColumn(Timestamp sqlTimestampColumn) {
        this.sqlTimestampColumn = sqlTimestampColumn;
    }

    public java.sql.Date getSqlDateColumn() {
        return sqlDateColumn;
    }

    public void setSqlDateColumn(java.sql.Date sqlDateColumn) {
        this.sqlDateColumn = sqlDateColumn;
    }

    public Time getSqlTimeColumn() {
        return sqlTimeColumn;
    }

    public void setSqlTimeColumn(Time sqlTimeColumn) {
        this.sqlTimeColumn = sqlTimeColumn;
    }


}
