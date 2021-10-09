/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.controller.comprador;

/**
 *
 * @author JUS
 */
public interface IComprador {

    public String addC(String[] data);

    public String[] find(String id);

    public String deleteC(String id);

    public String[][] getAll();
}
