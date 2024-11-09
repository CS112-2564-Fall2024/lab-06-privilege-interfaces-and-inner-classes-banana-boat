public class Person implements Comparable<Person> {

    // CONSTANT VARIABLES
    public static final String DEFAULT_NAME = "Jamie Doe";
    public static final String DEFAULT_PRONOUNS = "They/Them";
    public static final String DEFAULT_BACKGROUND = "Unknown";
    public static final int DEFAULT_PRIVILEGE = 100;

    // INSTANCE VARIABLES
    private String name;
    private Identity story; 
    private int privilege;

    // Inner class for Identity
    public class Identity {
        private String pronouns;
        private String background;

        // Constructors for Identity
        public Identity(String pronouns, String background) {
            this.pronouns = pronouns;
            this.background = background;
        }

        public Identity() {
            this(DEFAULT_PRONOUNS, DEFAULT_BACKGROUND);
        }

        // Getters and Setters for Identity
        public String getPronouns() {
            return pronouns;
        }

        public void setPronouns(String pronouns) {
            this.pronouns = pronouns;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        @Override
        public String toString() {
            return "Background: " + background + ", Pronouns: " + pronouns;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            if (other == null || getClass() != other.getClass()) return false;
            Identity identity = (Identity) other;
            return pronouns.equals(identity.pronouns) && background.equals(identity.background);
        }
    }

    // Constructors for Person
    public Person(String name, String pronouns, String background, int privilege) {
        this.name = name;
        this.story = new Identity(pronouns, background);
        this.privilege = privilege;
    }

    public Person() {
        this(DEFAULT_NAME, DEFAULT_PRONOUNS, DEFAULT_BACKGROUND, DEFAULT_PRIVILEGE);
    }

    public Person(Person original) {
        if (original == null) {
            throw new IllegalArgumentException("Cannot copy null object in Person copy constructor");
        }
        this.name = original.name;
        this.story = new Identity(original.story.getPronouns(), original.story.getBackground());
        this.privilege = original.privilege;
    }

    // Setters and getters for Person
    public void setName(String name) {
        this.name = name;
    }

    public void setPronouns(String pronouns) {
        this.story.setPronouns(pronouns);
    }

    public void setBackground(String background) {
        this.story.setBackground(background);
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    public void setAll(String name, String pronouns, String background, int privilege) {
        this.setName(name);
        this.setPronouns(pronouns);
        this.setBackground(background);
        this.setPrivilege(privilege);
    }

    public String getName() {
        return name;
    }

    public String getPronouns() {
        return story.getPronouns();
    }

    public String getBackground() {
        return story.getBackground();
    }

    public int getPrivilege() {
        return privilege;
    }

    @Override
    public String toString() {
        return "My name is " + name + ". " + story + "\n" +
               "According to this calculator I ended up with " + privilege + " estimated privilege points.";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Person person = (Person) other;
        return privilege == person.privilege &&
               name.equals(person.name) &&
               story.equals(person.story);
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.privilege, other.privilege);
    }
}
