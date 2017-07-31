package pya.marlon.com.examplegreendao.bean.model;

/**
 * Created by marlonpya on 29/07/17.
 */

public class ToyBean {
    private int id;
    private int fk_idPet;
    private String name;
    private boolean isNew;

    public ToyBean(int id, int fk_idPet, String name, boolean isNew) {
        this.id = id;
        this.fk_idPet = fk_idPet;
        this.name = name;
        this.isNew = isNew;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_idPet() {
        return fk_idPet;
    }

    public void setFk_idPet(int fk_idPet) {
        this.fk_idPet = fk_idPet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    @Override
    public String toString() {
        return "ToyBean{" +
                "id=" + id +
                ", fk_idPet=" + fk_idPet +
                ", name='" + name + '\'' +
                ", isNew=" + isNew +
                '}';
    }
}
