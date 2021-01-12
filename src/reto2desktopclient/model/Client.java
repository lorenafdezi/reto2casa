package reto2desktopclient.model;

import java.io.Serializable;
import java.util.Set;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Martin Angulo
 */
@XmlRootElement
public class Client extends User implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Set<Event> events;

    /**
     * @return the events
     */
    public Set<Event> getEvents() {
        return events;
    }

    /**
     * @param events the events to set
     */
    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}