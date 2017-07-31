package pya.marlon.com.examplegreendao.bean.model;

import java.util.List;

/**
 * Created by marlonpya on 29/07/17.
 */

public class PetBean {
    private int id;
    private int fk_idUser;
    private String name;
    private String alias;
    private double weight;
    private List<ToyBean> toys;

    public PetBean(int id, int fk_idUser, String name, String alias, double weight) {
        this.id = id;
        this.fk_idUser = fk_idUser;
        this.name = name;
        this.alias = alias;
        this.weight = weight;
    }

    public List<ToyBean> getToys() {
        return toys;
    }

    public void setToys(List<ToyBean> toys) {
        this.toys = toys;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_idUser() {
        return fk_idUser;
    }

    public void setFk_idUser(int fk_idUser) {
        this.fk_idUser = fk_idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "PetBean{" +
                "id=" + id +
                ", fk_idUser=" + fk_idUser +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", weight=" + weight +
                '}';
    }
}
