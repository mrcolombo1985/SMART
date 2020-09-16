package application.configurations.dbloader;

import application.repositories.data.ValueRepository;
import application.repositories.data.ArduinoDeviceRepository;
import application.repositories.data.DeviceRepository;
import application.repositories.data.OptionRepository;
import application.repositories.data.SensorRepository;
import application.repositories.user.RoleRepository;
import application.repositories.user.UserRepository;
import application.repositories.user.UserRoleRepository;
import application.repositories.video.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class LoaderDependencies { //TODO: stability risk with public access modifier on all repositories;
    @Autowired
    public Environment env;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public ValueRepository valueRepository;

    @Autowired
    public SensorRepository sensorRepository;

    @Autowired
    public DeviceRepository deviceRepository;

    @Autowired
    public OptionRepository optionRepository;

    @Autowired
    public CameraRepository cameraRepository;

    @Autowired
    public ArduinoDeviceRepository arduinoDeviceRepository;

    @Autowired
    public RoleRepository roleRepository;

    @Autowired
    public UserRoleRepository userRoleRepository;


    public LoaderDependencies() {
    }
}