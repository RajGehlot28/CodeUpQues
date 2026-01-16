class User {
    String name, Id, type;
    User() {};
    User(String name, String Id, String type) {
        this.name = name;
        this.Id = Id;
        this.type = type;
    }

    User createUser() {
        if(type.equals("faculty")) {
            return new Faculty(name, Id, type);
        } else {
            return new Student(name, Id, type);
        }
    }
}

class Faculty extends User {
    Faculty(String name, String Id, String type) {
        super(name, Id, type);
    }
}

class Student extends User {
    Student(String name, String Id, String type) {
        super(name, Id, type);
    }
}