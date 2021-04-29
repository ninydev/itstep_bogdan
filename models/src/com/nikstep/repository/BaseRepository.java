package com.nikstep.repository;

import java.util.LinkedList;

public class BaseRepository <Entity> {
    // Информаиця о группах
    private LinkedList<Entity> data = new LinkedList<>();

    /**
     * Реализация одиночки (данные могут храниться только в одном месте)
     */
    private BaseRepository() {}
    public static BaseRepository instance;
    public static BaseRepository getInstance() {
        if (instance == null) instance = new BaseRepository();
        return instance;
    }

    /**
     * Create
     * @param entity
     */
    public void create(Entity entity){
        try{
            data.add(entity);
        } catch (Exception ex){
            onException (ex);
        }
    }

    /**
     * Read
     * @param id
     * @return
     */
    public Entity read(int id){
        try {
            return data.get(id);
        } catch (Exception ex){
            onException(ex);
        }
        return null;
    }

    public LinkedList<Entity> readAll() {return data;}

    /**
     * Update
     * @param id
     * @param entity
     */
    public void update(int id, Entity entity) {
        try {
            data.set(id, entity);
        } catch (Exception ex) {
            onException(ex);
        }
    }


    /**
     * Delete
     * @param id
     */
    public void delete(int id){
        try{
            data.remove(id);
        } catch (Exception ex) {
            System.out.println("!!! Error !!!: \n" + ex.getMessage());
        }
    }

    /**
     * Поведение при ошибке
     * @param exception
     */
    public void onException (Exception exception) {
        System.out.println("!!! Error !!!: \n" + exception.getMessage());
    }
}
