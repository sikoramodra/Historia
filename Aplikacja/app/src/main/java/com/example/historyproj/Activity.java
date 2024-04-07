package com.example.historyproj;
import java.util.List;

public class Activity {
    private int id;
    private String name;
    private List<SubActivity> subActivity;

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

    public List<SubActivity> getSubActivity() {
        return subActivity;
    }

    public void setSubActivity(List<SubActivity> subActivity) {
        this.subActivity = subActivity;
    }

    public static class SubActivity {
        private int id;
        private String name;
        private List<Event> events;
        private int eventsLayoutId;

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

        public List<Event> getEvents() {
            return events;
        }

        public void setEvents(List<Event> events) {
            this.events = events;
        }

        public int getEventsLayoutId() {
            return eventsLayoutId;
        }

        public void setEventsLayoutId(int eventsLayoutId) {
            this.eventsLayoutId = eventsLayoutId;
        }
    }

    public static class Event {
        private int id;
        private String name;
        private int subActivityId;

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

        public int getSubActivityId() {
            return subActivityId;
        }

        public void setSubActivityId(int subActivityId) {
            this.subActivityId = subActivityId;
        }
    }
}
