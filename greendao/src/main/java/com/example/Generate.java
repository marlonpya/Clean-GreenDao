package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class Generate {
    private static final String PROJECT_DIR = System.getProperty("user.dir");
    private static final String DEFAULT = "/app/src/main/java/";

    public static void main(String [] args) {
        Schema schema = new Schema(5, "pya.marlon.com.examplegreendao.sql.model");
        schema.enableKeepSectionsByDefault();
        insertUser(schema);
        insertPet(schema);
        insertToy(schema);

        try {
            (new DaoGenerator()).generateAll(schema, PROJECT_DIR + DEFAULT);
        } catch (Exception e) {
            System.err.println("error sql");
            e.printStackTrace();
        }
    }

    private static void insertUser(Schema schema) {
        Entity entity = schema.addEntity("UserSQL");
        entity.addIdProperty().primaryKey().autoincrement();
        entity.addStringProperty("name");
        entity.addStringProperty("lastName");
        entity.addIntProperty("age");
    }

    private static void insertPet(Schema schema) {
        Entity entity = schema.addEntity("PetSQL");
        entity.addIdProperty().primaryKey().autoincrement();
        entity.addIntProperty("fk_idUser");
        entity.addStringProperty("name");
        entity.addStringProperty("alias");
        entity.addDoubleProperty("weight");
    }

    private static void insertToy(Schema schema) {
        Entity entity = schema.addEntity("ToySQL");
        entity.addIdProperty().primaryKey().autoincrement();
        entity.addIntProperty("fk_idPet");
        entity.addStringProperty("name");
        entity.addBooleanProperty("isNew");
    }
}
