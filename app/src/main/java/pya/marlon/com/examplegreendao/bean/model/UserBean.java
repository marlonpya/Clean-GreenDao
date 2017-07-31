package pya.marlon.com.examplegreendao.bean.model;

import java.util.List;

/**
 * Created by marlonpya on 29/07/17.
 */

public class UserBean {
    private int id;
    private String name;
    private String lastName;
    private int age;
    private List<PetBean> pets;

    public UserBean(int id, String name, String lastName, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public List<PetBean> getPets() {
        return pets;
    }

    public void setPets(List<PetBean> pets) {
        this.pets = pets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
