package application.configurations.dbloader;

//TODO: profile?
public enum MPHEntity {
    USER {
        public String dataFile() {
            return "data_user.csv";
        }
    },
    DEVICE {
        public String dataFile() {
            return "data_device.csv";
        }
    },
    SENSOR {
        public String dataFile() {
            return "data_sensor.csv";
        }
    },
    ARDUINO {
        public String dataFile() {
            return "data_arduino.csv";
        }
    },
    OPTIONS {
        public String dataFile() {
            return "data_options.csv";
        }
    },
    VALUE {
        public String dataFile() {
            return "data_value.csv";
        }
    },
    ROLE {
        public String dataFile() {
            return "data_role.csv";
        }
    },
    USERROLE {
        public String dataFile() {
            return "data_userrole.csv";
        }
    },
    CAMERA {
        public String dataFile() {
            return "data_camera.csv";
        }
    },


    LOGS {
        public String dataFile() {
            return "data_blank.csv";
        }
    };

    public abstract String dataFile();
}