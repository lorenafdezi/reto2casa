/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto2desktopclient.client;

/**
 *
 * @author Martin Angulo <martin.angulo at tartanga.eus>
 */
public interface EventManagerFactory {
    
    public static EventManager getEventManager() {
        return new EventRESTClient();
    }
}
