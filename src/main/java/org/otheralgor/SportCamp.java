package org.otheralgor;

public class SportCamp {

    private String name;
    private Integer countDay;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountDay() {
        return countDay;
    }

    public void setCountDay(Integer countDay) {
        this.countDay = countDay;
    }

    public SportCamp(String name, int countDay) {
        this.name = name;
        this.countDay = countDay;
    }

    @Override
    public String toString() {
        return "SportCamp{" +
                "name='" + name + '\'' +
                ", countDay=" + countDay +
                '}';
    }
}
