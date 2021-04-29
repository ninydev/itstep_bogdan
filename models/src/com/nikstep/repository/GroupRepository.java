package com.nikstep.repository;
/**
 * Хранилище групп
 * -------------------------------------------------------------------------
 *
 */


import com.nikstep.entity.Group;

import java.util.LinkedList;
import java.util.List;

public class GroupRepository {

    // Информаиця о группах
    private LinkedList<Group> data = new LinkedList<>();

    /**
     * Реализация одиночки (данные могут храниться только в одном месте)
     */
    private GroupRepository() {}
    public static GroupRepository instance;
    public static GroupRepository getInstance() {
        if (instance == null) instance = new GroupRepository();
        return instance;
    }

    /**
     * Create
     * @param group
     */
    public void create(Group group){ data.add(group); }

    /**
     * Read
     * @param id
     * @return
     */
    public Group read(int id){ return  data.get(id);}
    public LinkedList<Group> readAll() {return data;}

    /**
     * Update
     * @param id
     * @param g
     */
    public void update(int id, Group g){ data.set(id, g);}

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



}
