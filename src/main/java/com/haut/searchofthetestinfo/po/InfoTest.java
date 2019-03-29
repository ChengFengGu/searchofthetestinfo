package com.haut.searchofthetestinfo.po;

public class InfoTest {
    public String test_id;
    public String person_id;
    public String name;
    public String majorOfApply;
    public String instituteOfApply;
    public String foreignLanguage;
    public String firstCourse;
    public String secondCourse;
    public String total;

    @Override
    public String toString() {
        return "InfoTest{" +
                "test_id='" + test_id + '\'' +
                ", person_id='" + person_id + '\'' +
                ", name='" + name + '\'' +
                ", majorOfApply='" + majorOfApply + '\'' +
                ", instituteOfApply='" + instituteOfApply + '\'' +
                ", foreignLanguage='" + foreignLanguage + '\'' +
                ", firstCourse='" + firstCourse + '\'' +
                ", secondCourse='" + secondCourse + '\'' +
                ", total='" + total + '\'' +
                '}';
    }

    public String getTest_id() {
        return test_id;
    }

    public void setTest_id(String test_id) {
        this.test_id = test_id;
    }

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajorOfApply() {
        return majorOfApply;
    }

    public void setMajorOfApply(String majorOfApply) {
        this.majorOfApply = majorOfApply;
    }

    public String getInstituteOfApply() {
        return instituteOfApply;
    }

    public void setInstituteOfApply(String instituteOfApply) {
        this.instituteOfApply = instituteOfApply;
    }

    public String getForeignLanguage() {
        return foreignLanguage;
    }

    public void setForeignLanguage(String foreignLanguage) {
        this.foreignLanguage = foreignLanguage;
    }

    public String getFirstCourse() {
        return firstCourse;
    }

    public void setFirstCourse(String firstCourse) {
        this.firstCourse = firstCourse;
    }

    public String getSecondCourse() {
        return secondCourse;
    }

    public void setSecondCourse(String secondCourse) {
        this.secondCourse = secondCourse;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
