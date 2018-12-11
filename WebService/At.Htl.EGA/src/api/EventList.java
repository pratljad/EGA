package api;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import domains.Event;

@XmlRootElement(name = "eventlist")
public class EventList {
  @XmlElement(name = "param")
  private String param;
  @XmlElement(name = "entities")
  private List<Event> events;
}
