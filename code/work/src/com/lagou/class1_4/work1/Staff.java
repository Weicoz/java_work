package com.lagou.class1_4.work1;

public class Staff {

    private String name;
    private int age;

    public Staff() {}

    public Staff(String name, int age) throws AgeException, EmptyException{
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws EmptyException {
        if (name == null || name.equals("")) {
            throw new EmptyException("名称不能为空");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws AgeException {
        if (age < 18) {
            throw new AgeException("年龄太小");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    public static void main(String[] args) {
        Staff staff = new Staff();
        try {
            staff.setName("");
            staff.setAge(18);
//            staff = new Staff("测试人员", 33);
            System.out.println(staff);
        } catch (EmptyException | AgeException e) {
            e.printStackTrace();
        }
    }
}
