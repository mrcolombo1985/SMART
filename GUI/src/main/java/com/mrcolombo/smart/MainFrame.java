/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcolombo.smart;

import com.mrcolombo.smart.dialogs.arduino.*;
import com.mrcolombo.smart.dialogs.camera.*;
import com.mrcolombo.smart.dialogs.device.*;
import com.mrcolombo.smart.dialogs.option.*;
import com.mrcolombo.smart.dialogs.sensor.*;
import com.mrcolombo.smart.dtoes.security.LoginResponse;
import com.mrcolombo.smart.provider.data.*;
import com.mrcolombo.smart.provider.CameraProvider;
import com.mrcolombo.smart.provider.security.LoginProvider;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class MainFrame extends javax.swing.JFrame {


    public void setColumns(JTable jTable) {
        DefaultTableModel tableModel = new DefaultTableModel();
        columnNames.forEach((columnName) -> {
            tableModel.addColumn(columnName);
        });
        jTable.setModel(tableModel);
    }

    public static String token;
    private List<String> columnNames = new ArrayList<>();

    public MainFrame() {
        initComponents();
        LoginProvider loginProvider = new LoginProvider();
        LoginResponse loginResponse = loginProvider.login();
        token = loginResponse.getToken();
        System.out.println("Hello " + token);
        DeviceProvider deviceProvider = new DeviceProvider();
        List<String> deviceListName = new ArrayList<>();
        try {
            deviceProvider.fromServer().forEach(x -> {
                deviceListName.add(x.getName());
            });
        } catch (URISyntaxException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        deviceProvider.load(devicesViewTable);
        SensorProvider sensorProvider = new SensorProvider();
        sensorProvider.load(sensorViewTable);
        columsNamesInit();
        initOptionsTables();
        loadOptinsToTables(deviceListName);
        addMenuTitles();
        removeMenuTitles();
        editMenuTitles();
        clearAllMenuTitles();
        CameraProvider cameraProvider = new CameraProvider();
        cameraProvider.load(CamersViewTable, token);
        ArduinoDeviceProvider arduinoDeviceProvider = new ArduinoDeviceProvider();
        arduinoDeviceProvider.load(ArduinoDeviceViewTable);
    }

    private void clearAllMenuTitles() {
        device1ClearAll.setText("Clear All");
        device2ClearAll.setText("Clear All");
        device3ClearAll.setText("Clear All");
        device4ClearAll.setText("Clear All");
        device5ClearAll.setText("Clear All");
        device6ClearAll.setText("Clear All");
        device7ClearAll.setText("Clear All");
        device8ClearAll.setText("Clear All");
        device9ClearAll.setText("Clear All");
        device10ClearAll.setText("Clear All");
        device11ClearAll.setText("Clear All");
        device12ClearAll.setText("Clear All");
        device13ClearAll.setText("Clear All");
        device14ClearAll.setText("Clear All");
        device15ClearAll.setText("Clear All");
        device16ClearAll.setText("Clear All");
        device17ClearAll.setText("Clear All");
        device18ClearAll.setText("Clear All");
        device19ClearAll.setText("Clear All");
        device20ClearAll.setText("Clear All");
        device21ClearAll.setText("Clear All");
        device22ClearAll.setText("Clear All");
        device23ClearAll.setText("Clear All");
        device24ClearAll.setText("Clear All");
        device25ClearAll.setText("Clear All");
        device26ClearAll.setText("Clear All");
        device27ClearAll.setText("Clear All");
        device28ClearAll.setText("Clear All");
        device29ClearAll.setText("Clear All");
        device30ClearAll.setText("Clear All");
        device31ClearAll.setText("Clear All");
        device32ClearAll.setText("Clear All");
    }

    private void editMenuTitles() {
        device1Edit.setText("Edit");
        device2Edit.setText("Edit");
        device3Edit.setText("Edit");
        device4Edit.setText("Edit");
        device5Edit.setText("Edit");
        device6Edit.setText("Edit");
        device7Edit.setText("Edit");
        device8Edit.setText("Edit");
        device9Edit.setText("Edit");
        device10Edit.setText("Edit");
        device11Edit.setText("Edit");
        device12Edit.setText("Edit");
        device13Edit.setText("Edit");
        device14Edit.setText("Edit");
        device15Edit.setText("Edit");
        device16Edit.setText("Edit");
        device17Edit.setText("Edit");
        device18Edit.setText("Edit");
        device19Edit.setText("Edit");
        device20Edit.setText("Edit");
        device21Edit.setText("Edit");
        device22Edit.setText("Edit");
        device23Edit.setText("Edit");
        device24Edit.setText("Edit");
        device25Edit.setText("Edit");
        device26Edit.setText("Edit");
        device27Edit.setText("Edit");
        device28Edit.setText("Edit");
        device29Edit.setText("Edit");
        device30Edit.setText("Edit");
        device31Edit.setText("Edit");
        device32Edit.setText("Edit");
    }

    private void removeMenuTitles() {
        device1Remove.setText("Remove");
        device2Remove.setText("Remove");
        device3Remove.setText("Remove");
        device4Remove.setText("Remove");
        device5Remove.setText("Remove");
        device6Remove.setText("Remove");
        device7Remove.setText("Remove");
        device8Remove.setText("Remove");
        device9Remove.setText("Remove");
        device10Remove.setText("Remove");
        device11Remove.setText("Remove");
        device12Remove.setText("Remove");
        device13Remove.setText("Remove");
        device14Remove.setText("Remove");
        device15Remove.setText("Remove");
        device16Remove.setText("Remove");
        device17Remove.setText("Remove");
        device18Remove.setText("Remove");
        device19Remove.setText("Remove");
        device20Remove.setText("Remove");
        device21Remove.setText("Remove");
        device22Remove.setText("Remove");
        device23Remove.setText("Remove");
        device24Remove.setText("Remove");
        device25Remove.setText("Remove");
        device26Remove.setText("Remove");
        device27Remove.setText("Remove");
        device28Remove.setText("Remove");
        device29Remove.setText("Remove");
        device30Remove.setText("Remove");
        device31Remove.setText("Remove");
        device32Remove.setText("Remove");
    }

    private void addMenuTitles() {
        device1Add.setText("Add");
        device2Add.setText("Add");
        device3Add.setText("Add");
        device4Add.setText("Add");
        device5Add.setText("Add");
        device6Add.setText("Add");
        device7Add.setText("Add");
        device8Add.setText("Add");
        device9Add.setText("Add");
        device10Add.setText("Add");
        device11Add.setText("Add");
        device12Add.setText("Add");
        device13Add.setText("Add");
        device14Add.setText("Add");
        device15Add.setText("Add");
        device16Add.setText("Add");
        device17Add.setText("Add");
        device18Add.setText("Add");
        device19Add.setText("Add");
        device20Add.setText("Add");
        device21Add.setText("Add");
        device22Add.setText("Add");
        device23Add.setText("Add");
        device24Add.setText("Add");
        device25Add.setText("Add");
        device26Add.setText("Add");
        device27Add.setText("Add");
        device28Add.setText("Add");
        device29Add.setText("Add");
        device30Add.setText("Add");
        device31Add.setText("Add");
        device32Add.setText("Add");
    }

    private void loadOptinsToTables(List<String> deviceListName) {
        OptionProvider optionProvider = new OptionProvider();
        optionProvider.load(device1, deviceListName.get(0));
        optionProvider.load(device2, deviceListName.get(1));
        optionProvider.load(device3, deviceListName.get(2));
        optionProvider.load(device4, deviceListName.get(3));
        optionProvider.load(device5, deviceListName.get(4));
        optionProvider.load(device6, deviceListName.get(5));
        optionProvider.load(device7, deviceListName.get(6));
        optionProvider.load(device8, deviceListName.get(7));
        optionProvider.load(device9, deviceListName.get(8));
        optionProvider.load(device10, deviceListName.get(9));
        optionProvider.load(device11, deviceListName.get(10));
        optionProvider.load(device12, deviceListName.get(11));
        optionProvider.load(device13, deviceListName.get(12));
        optionProvider.load(device14, deviceListName.get(13));
        optionProvider.load(device15, deviceListName.get(14));
        optionProvider.load(device16, deviceListName.get(15));
        optionProvider.load(device17, deviceListName.get(16));
        optionProvider.load(device18, deviceListName.get(17));
        optionProvider.load(device19, deviceListName.get(18));
        optionProvider.load(device20, deviceListName.get(19));
        optionProvider.load(device21, deviceListName.get(20));
        optionProvider.load(device22, deviceListName.get(21));
        optionProvider.load(device23, deviceListName.get(22));
        optionProvider.load(device24, deviceListName.get(23));
        optionProvider.load(device25, deviceListName.get(24));
        optionProvider.load(device26, deviceListName.get(25));
        optionProvider.load(device27, deviceListName.get(26));
        optionProvider.load(device28, deviceListName.get(27));
        optionProvider.load(device29, deviceListName.get(28));
        optionProvider.load(device30, deviceListName.get(29));
        optionProvider.load(device31, deviceListName.get(30));
        optionProvider.load(device32, deviceListName.get(31));
    }

    private void initOptionsTables() {
        setColumns(device1);
        setColumns(device2);
        setColumns(device3);
        setColumns(device4);
        setColumns(device5);
        setColumns(device6);
        setColumns(device7);
        setColumns(device8);
        setColumns(device9);
        setColumns(device10);
        setColumns(device11);
        setColumns(device12);
        setColumns(device13);
        setColumns(device14);
        setColumns(device15);
        setColumns(device16);
        setColumns(device17);
        setColumns(device18);
        setColumns(device19);
        setColumns(device20);
        setColumns(device21);
        setColumns(device22);
        setColumns(device23);
        setColumns(device24);
        setColumns(device25);
        setColumns(device26);
        setColumns(device27);
        setColumns(device28);
        setColumns(device29);
        setColumns(device30);
        setColumns(device31);
        setColumns(device32);
    }

    private void columsNamesInit() {
        columnNames.add("Name");
        columnNames.add("Type");
        columnNames.add("If");
        columnNames.add("Sensor");
        columnNames.add("Date");
        columnNames.add("Time");
        columnNames.add("Value");
        columnNames.add("Description");
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        device1Menu = new javax.swing.JPopupMenu();
        device1Add = new javax.swing.JMenuItem();
        device1Remove = new javax.swing.JMenuItem();
        device1Edit = new javax.swing.JMenuItem();
        device1ClearAll = new javax.swing.JMenuItem();
        arduinoMenu = new javax.swing.JPopupMenu();
        addArduino = new javax.swing.JMenuItem();
        editArduino = new javax.swing.JMenuItem();
        deleteArduino = new javax.swing.JMenuItem();
        sensorMenu = new javax.swing.JPopupMenu();
        addSensor = new javax.swing.JMenuItem();
        editSensor = new javax.swing.JMenuItem();
        displayValueSensor = new javax.swing.JMenuItem();
        deleteSensor = new javax.swing.JMenuItem();
        cameraMenu = new javax.swing.JPopupMenu();
        addCamera = new javax.swing.JMenuItem();
        editCamera = new javax.swing.JMenuItem();
        deleteCamera = new javax.swing.JMenuItem();
        deviceMenu = new javax.swing.JPopupMenu();
        addDevice = new javax.swing.JMenuItem();
        editDevice = new javax.swing.JMenuItem();
        deleteDevice = new javax.swing.JMenuItem();
        device2Menu = new javax.swing.JPopupMenu();
        device2Add = new javax.swing.JMenuItem();
        device2Remove = new javax.swing.JMenuItem();
        device2Edit = new javax.swing.JMenuItem();
        device2ClearAll = new javax.swing.JMenuItem();
        device3Menu = new javax.swing.JPopupMenu();
        device3Add = new javax.swing.JMenuItem();
        device3Remove = new javax.swing.JMenuItem();
        device3Edit = new javax.swing.JMenuItem();
        device3ClearAll = new javax.swing.JMenuItem();
        device4Menu = new javax.swing.JPopupMenu();
        device4Add = new javax.swing.JMenuItem();
        device4Remove = new javax.swing.JMenuItem();
        device4Edit = new javax.swing.JMenuItem();
        device4ClearAll = new javax.swing.JMenuItem();
        device5Menu = new javax.swing.JPopupMenu();
        device5Add = new javax.swing.JMenuItem();
        device5Remove = new javax.swing.JMenuItem();
        device5Edit = new javax.swing.JMenuItem();
        device5ClearAll = new javax.swing.JMenuItem();
        device6Menu = new javax.swing.JPopupMenu();
        device6Add = new javax.swing.JMenuItem();
        device6Remove = new javax.swing.JMenuItem();
        device6Edit = new javax.swing.JMenuItem();
        device6ClearAll = new javax.swing.JMenuItem();
        device7Menu = new javax.swing.JPopupMenu();
        device7Add = new javax.swing.JMenuItem();
        device7Remove = new javax.swing.JMenuItem();
        device7Edit = new javax.swing.JMenuItem();
        device7ClearAll = new javax.swing.JMenuItem();
        device8Menu = new javax.swing.JPopupMenu();
        device8Add = new javax.swing.JMenuItem();
        device8Remove = new javax.swing.JMenuItem();
        device8Edit = new javax.swing.JMenuItem();
        device8ClearAll = new javax.swing.JMenuItem();
        device9Menu = new javax.swing.JPopupMenu();
        device9Add = new javax.swing.JMenuItem();
        device9Remove = new javax.swing.JMenuItem();
        device9Edit = new javax.swing.JMenuItem();
        device9ClearAll = new javax.swing.JMenuItem();
        device10Menu = new javax.swing.JPopupMenu();
        device10Add = new javax.swing.JMenuItem();
        device10Remove = new javax.swing.JMenuItem();
        device10Edit = new javax.swing.JMenuItem();
        device10ClearAll = new javax.swing.JMenuItem();
        device11Menu = new javax.swing.JPopupMenu();
        device11Add = new javax.swing.JMenuItem();
        device11Remove = new javax.swing.JMenuItem();
        device11Edit = new javax.swing.JMenuItem();
        device11ClearAll = new javax.swing.JMenuItem();
        device12Menu = new javax.swing.JPopupMenu();
        device12Add = new javax.swing.JMenuItem();
        device12Remove = new javax.swing.JMenuItem();
        device12Edit = new javax.swing.JMenuItem();
        device12ClearAll = new javax.swing.JMenuItem();
        device13Menu = new javax.swing.JPopupMenu();
        device13Add = new javax.swing.JMenuItem();
        device13Remove = new javax.swing.JMenuItem();
        device13Edit = new javax.swing.JMenuItem();
        device13ClearAll = new javax.swing.JMenuItem();
        device14Menu = new javax.swing.JPopupMenu();
        device14Add = new javax.swing.JMenuItem();
        device14Remove = new javax.swing.JMenuItem();
        device14Edit = new javax.swing.JMenuItem();
        device14ClearAll = new javax.swing.JMenuItem();
        device15Menu = new javax.swing.JPopupMenu();
        device15Add = new javax.swing.JMenuItem();
        device15Remove = new javax.swing.JMenuItem();
        device15Edit = new javax.swing.JMenuItem();
        device15ClearAll = new javax.swing.JMenuItem();
        device16Menu = new javax.swing.JPopupMenu();
        device16Add = new javax.swing.JMenuItem();
        device16Remove = new javax.swing.JMenuItem();
        device16Edit = new javax.swing.JMenuItem();
        device16ClearAll = new javax.swing.JMenuItem();
        device17Menu = new javax.swing.JPopupMenu();
        device17Add = new javax.swing.JMenuItem();
        device17Remove = new javax.swing.JMenuItem();
        device17Edit = new javax.swing.JMenuItem();
        device17ClearAll = new javax.swing.JMenuItem();
        device18Menu = new javax.swing.JPopupMenu();
        device18Add = new javax.swing.JMenuItem();
        device18Remove = new javax.swing.JMenuItem();
        device18Edit = new javax.swing.JMenuItem();
        device18ClearAll = new javax.swing.JMenuItem();
        device19Menu = new javax.swing.JPopupMenu();
        device19Add = new javax.swing.JMenuItem();
        device19Remove = new javax.swing.JMenuItem();
        device19Edit = new javax.swing.JMenuItem();
        device19ClearAll = new javax.swing.JMenuItem();
        device20Menu = new javax.swing.JPopupMenu();
        device20Add = new javax.swing.JMenuItem();
        device20Remove = new javax.swing.JMenuItem();
        device20Edit = new javax.swing.JMenuItem();
        device20ClearAll = new javax.swing.JMenuItem();
        device21Menu = new javax.swing.JPopupMenu();
        device21Add = new javax.swing.JMenuItem();
        device21Remove = new javax.swing.JMenuItem();
        device21Edit = new javax.swing.JMenuItem();
        device21ClearAll = new javax.swing.JMenuItem();
        device22Menu = new javax.swing.JPopupMenu();
        device22Add = new javax.swing.JMenuItem();
        device22Remove = new javax.swing.JMenuItem();
        device22Edit = new javax.swing.JMenuItem();
        device22ClearAll = new javax.swing.JMenuItem();
        device23Menu = new javax.swing.JPopupMenu();
        device23Add = new javax.swing.JMenuItem();
        device23Remove = new javax.swing.JMenuItem();
        device23Edit = new javax.swing.JMenuItem();
        device23ClearAll = new javax.swing.JMenuItem();
        device24Menu = new javax.swing.JPopupMenu();
        device24Add = new javax.swing.JMenuItem();
        device24Remove = new javax.swing.JMenuItem();
        device24Edit = new javax.swing.JMenuItem();
        device24ClearAll = new javax.swing.JMenuItem();
        device25Menu = new javax.swing.JPopupMenu();
        device25Add = new javax.swing.JMenuItem();
        device25Remove = new javax.swing.JMenuItem();
        device25Edit = new javax.swing.JMenuItem();
        device25ClearAll = new javax.swing.JMenuItem();
        device26Menu = new javax.swing.JPopupMenu();
        device26Add = new javax.swing.JMenuItem();
        device26Remove = new javax.swing.JMenuItem();
        device26Edit = new javax.swing.JMenuItem();
        device26ClearAll = new javax.swing.JMenuItem();
        device27Menu = new javax.swing.JPopupMenu();
        device27Add = new javax.swing.JMenuItem();
        device27Remove = new javax.swing.JMenuItem();
        device27Edit = new javax.swing.JMenuItem();
        device27ClearAll = new javax.swing.JMenuItem();
        device28Menu = new javax.swing.JPopupMenu();
        device28Add = new javax.swing.JMenuItem();
        device28Remove = new javax.swing.JMenuItem();
        device28Edit = new javax.swing.JMenuItem();
        device28ClearAll = new javax.swing.JMenuItem();
        device29Menu = new javax.swing.JPopupMenu();
        device29Add = new javax.swing.JMenuItem();
        device29Remove = new javax.swing.JMenuItem();
        device29Edit = new javax.swing.JMenuItem();
        device29ClearAll = new javax.swing.JMenuItem();
        device30Menu = new javax.swing.JPopupMenu();
        device30Add = new javax.swing.JMenuItem();
        device30Remove = new javax.swing.JMenuItem();
        device30Edit = new javax.swing.JMenuItem();
        device30ClearAll = new javax.swing.JMenuItem();
        device31Menu = new javax.swing.JPopupMenu();
        device31Add = new javax.swing.JMenuItem();
        device31Remove = new javax.swing.JMenuItem();
        device31Edit = new javax.swing.JMenuItem();
        device31ClearAll = new javax.swing.JMenuItem();
        device32Menu = new javax.swing.JPopupMenu();
        device32Add = new javax.swing.JMenuItem();
        device32Remove = new javax.swing.JMenuItem();
        device32Edit = new javax.swing.JMenuItem();
        device32ClearAll = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        sensorViewTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        optionsViewTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        devicesViewTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ArduinoDeviceViewTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        CamersViewTable = new javax.swing.JTable();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        device1Panel = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        device1 = new javax.swing.JTable();
        device2Panel = new javax.swing.JPanel();
        jScrollPane23 = new javax.swing.JScrollPane();
        device2 = new javax.swing.JTable();
        device3Panel = new javax.swing.JPanel();
        jScrollPane24 = new javax.swing.JScrollPane();
        device3 = new javax.swing.JTable();
        device4Panel = new javax.swing.JPanel();
        jScrollPane25 = new javax.swing.JScrollPane();
        device4 = new javax.swing.JTable();
        device5Panel = new javax.swing.JPanel();
        jScrollPane26 = new javax.swing.JScrollPane();
        device5 = new javax.swing.JTable();
        device6Panel = new javax.swing.JPanel();
        jScrollPane27 = new javax.swing.JScrollPane();
        device6 = new javax.swing.JTable();
        device7Panel = new javax.swing.JPanel();
        jScrollPane28 = new javax.swing.JScrollPane();
        device7 = new javax.swing.JTable();
        device8Panel = new javax.swing.JPanel();
        jScrollPane29 = new javax.swing.JScrollPane();
        device8 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jTabbedPane8 = new javax.swing.JTabbedPane();
        device9Panel = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        device9 = new javax.swing.JTable();
        device10Panel = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        device10 = new javax.swing.JTable();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        device11 = new javax.swing.JTable();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        device12 = new javax.swing.JTable();
        jPanel27 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        device13 = new javax.swing.JTable();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        device14 = new javax.swing.JTable();
        jPanel29 = new javax.swing.JPanel();
        jScrollPane20 = new javax.swing.JScrollPane();
        device15 = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        device16 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jTabbedPane9 = new javax.swing.JTabbedPane();
        jPanel31 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        device17 = new javax.swing.JTable();
        jPanel32 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        device18 = new javax.swing.JTable();
        jPanel33 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        device19 = new javax.swing.JTable();
        jPanel34 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        device20 = new javax.swing.JTable();
        jPanel35 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        device21 = new javax.swing.JTable();
        jPanel36 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        device22 = new javax.swing.JTable();
        jPanel37 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        device23 = new javax.swing.JTable();
        jPanel38 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        device24 = new javax.swing.JTable();
        jPanel39 = new javax.swing.JPanel();
        jTabbedPane10 = new javax.swing.JTabbedPane();
        jPanel40 = new javax.swing.JPanel();
        jScrollPane30 = new javax.swing.JScrollPane();
        device25 = new javax.swing.JTable();
        jPanel41 = new javax.swing.JPanel();
        jScrollPane31 = new javax.swing.JScrollPane();
        device26 = new javax.swing.JTable();
        jPanel42 = new javax.swing.JPanel();
        jScrollPane32 = new javax.swing.JScrollPane();
        device27 = new javax.swing.JTable();
        jPanel43 = new javax.swing.JPanel();
        jScrollPane33 = new javax.swing.JScrollPane();
        device28 = new javax.swing.JTable();
        jPanel44 = new javax.swing.JPanel();
        jScrollPane34 = new javax.swing.JScrollPane();
        device29 = new javax.swing.JTable();
        jPanel45 = new javax.swing.JPanel();
        jScrollPane35 = new javax.swing.JScrollPane();
        device30 = new javax.swing.JTable();
        jPanel46 = new javax.swing.JPanel();
        jScrollPane36 = new javax.swing.JScrollPane();
        device31 = new javax.swing.JTable();
        jPanel47 = new javax.swing.JPanel();
        jScrollPane37 = new javax.swing.JScrollPane();
        device32 = new javax.swing.JTable();

        device1Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device1MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device1Add.setText("Add");
        device1Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device1AddMousePressed(evt);
            }
        });
        device1Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                device1AddActionPerformed(evt);
            }
        });
        device1Menu.add(device1Add);

        device1Remove.setText("Remove");
        device1Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device1RemoveMousePressed(evt);
            }
        });
        device1Menu.add(device1Remove);

        device1Edit.setText("Edit");
        device1Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                device1EditMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device1EditMousePressed(evt);
            }
        });
        device1Menu.add(device1Edit);

        device1ClearAll.setText("Clear All");
        device1ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device1ClearAllMousePressed(evt);
            }
        });
        device1Menu.add(device1ClearAll);

        addArduino.setText("Add");
        addArduino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addArduinoMousePressed(evt);
            }
        });
        arduinoMenu.add(addArduino);

        editArduino.setText("Edit");
        editArduino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editArduinoMousePressed(evt);
            }
        });
        arduinoMenu.add(editArduino);

        deleteArduino.setText("Delete");
        deleteArduino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteArduinoMousePressed(evt);
            }
        });
        arduinoMenu.add(deleteArduino);

        addSensor.setText("Add");
        addSensor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addSensorMousePressed(evt);
            }
        });
        addSensor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSensorActionPerformed(evt);
            }
        });
        sensorMenu.add(addSensor);

        editSensor.setText("Edit");
        editSensor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editSensorMousePressed(evt);
            }
        });
        sensorMenu.add(editSensor);

        displayValueSensor.setText("Value");
        displayValueSensor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                displayValueSensorMousePressed(evt);
            }
        });
        sensorMenu.add(displayValueSensor);

        deleteSensor.setText("Delete");
        deleteSensor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteSensorMousePressed(evt);
            }
        });
        sensorMenu.add(deleteSensor);

        addCamera.setText("Add");
        addCamera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addCameraMousePressed(evt);
            }
        });
        cameraMenu.add(addCamera);

        editCamera.setText("Edit");
        editCamera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editCameraMousePressed(evt);
            }
        });
        cameraMenu.add(editCamera);

        deleteCamera.setText("Delete");
        deleteCamera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteCameraMousePressed(evt);
            }
        });
        cameraMenu.add(deleteCamera);

        addDevice.setText("Add");
        addDevice.setEnabled(false);
        addDevice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addDeviceMousePressed(evt);
            }
        });
        addDevice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDeviceActionPerformed(evt);
            }
        });
        deviceMenu.add(addDevice);

        editDevice.setText("Edit");
        editDevice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editDeviceMousePressed(evt);
            }
        });
        editDevice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDeviceActionPerformed(evt);
            }
        });
        deviceMenu.add(editDevice);

        deleteDevice.setText("Delete");
        deleteDevice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteDeviceMousePressed(evt);
            }
        });
        deviceMenu.add(deleteDevice);

        device2Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device2MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device2Add.setText("jMenuItem1");
        device2Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device2AddMousePressed(evt);
            }
        });
        device2Menu.add(device2Add);

        device2Remove.setText("jMenuItem1");
        device2Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device2RemoveMousePressed(evt);
            }
        });
        device2Menu.add(device2Remove);

        device2Edit.setText("jMenuItem1");
        device2Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device2EditMousePressed(evt);
            }
        });
        device2Menu.add(device2Edit);

        device2ClearAll.setText("jMenuItem1");
        device2ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device2ClearAllMousePressed(evt);
            }
        });
        device2Menu.add(device2ClearAll);

        device3Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device3MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device3Add.setText("jMenuItem1");
        device3Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device3AddMousePressed(evt);
            }
        });
        device3Menu.add(device3Add);

        device3Remove.setText("jMenuItem1");
        device3Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device3RemoveMousePressed(evt);
            }
        });
        device3Menu.add(device3Remove);

        device3Edit.setText("jMenuItem1");
        device3Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device3EditMousePressed(evt);
            }
        });
        device3Menu.add(device3Edit);

        device3ClearAll.setText("jMenuItem1");
        device3ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device3ClearAllMousePressed(evt);
            }
        });
        device3Menu.add(device3ClearAll);

        device4Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device4MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device4Add.setText("jMenuItem1");
        device4Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device4AddMousePressed(evt);
            }
        });
        device4Menu.add(device4Add);

        device4Remove.setText("jMenuItem1");
        device4Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device4RemoveMousePressed(evt);
            }
        });
        device4Menu.add(device4Remove);

        device4Edit.setText("jMenuItem1");
        device4Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device4EditMousePressed(evt);
            }
        });
        device4Menu.add(device4Edit);

        device4ClearAll.setText("jMenuItem1");
        device4ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device4ClearAllMousePressed(evt);
            }
        });
        device4Menu.add(device4ClearAll);

        device5Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device5MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device5Add.setText("jMenuItem1");
        device5Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device5AddMousePressed(evt);
            }
        });
        device5Menu.add(device5Add);

        device5Remove.setText("jMenuItem1");
        device5Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device5RemoveMousePressed(evt);
            }
        });
        device5Menu.add(device5Remove);

        device5Edit.setText("jMenuItem1");
        device5Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device5EditMousePressed(evt);
            }
        });
        device5Menu.add(device5Edit);

        device5ClearAll.setText("jMenuItem1");
        device5ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device5ClearAllMousePressed(evt);
            }
        });
        device5Menu.add(device5ClearAll);

        device6Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device6MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device6Add.setText("jMenuItem1");
        device6Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device6AddMousePressed(evt);
            }
        });
        device6Menu.add(device6Add);

        device6Remove.setText("jMenuItem1");
        device6Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device6RemoveMousePressed(evt);
            }
        });
        device6Menu.add(device6Remove);

        device6Edit.setText("jMenuItem1");
        device6Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device6EditMousePressed(evt);
            }
        });
        device6Menu.add(device6Edit);

        device6ClearAll.setText("jMenuItem1");
        device6ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device6ClearAllMousePressed(evt);
            }
        });
        device6Menu.add(device6ClearAll);

        device7Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device7MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device7Add.setText("jMenuItem1");
        device7Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device7AddMousePressed(evt);
            }
        });
        device7Menu.add(device7Add);

        device7Remove.setText("jMenuItem1");
        device7Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device7RemoveMousePressed(evt);
            }
        });
        device7Menu.add(device7Remove);

        device7Edit.setText("jMenuItem1");
        device7Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device7EditMousePressed(evt);
            }
        });
        device7Menu.add(device7Edit);

        device7ClearAll.setText("jMenuItem1");
        device7ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device7ClearAllMousePressed(evt);
            }
        });
        device7Menu.add(device7ClearAll);

        device8Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device8MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device8Add.setText("jMenuItem1");
        device8Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device8AddMousePressed(evt);
            }
        });
        device8Menu.add(device8Add);

        device8Remove.setText("jMenuItem1");
        device8Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device8RemoveMousePressed(evt);
            }
        });
        device8Menu.add(device8Remove);

        device8Edit.setText("jMenuItem1");
        device8Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device8EditMousePressed(evt);
            }
        });
        device8Menu.add(device8Edit);

        device8ClearAll.setText("jMenuItem1");
        device8ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device8ClearAllMousePressed(evt);
            }
        });
        device8Menu.add(device8ClearAll);

        device9Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device9MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device9Add.setText("jMenuItem1");
        device9Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device9AddMousePressed(evt);
            }
        });
        device9Menu.add(device9Add);

        device9Remove.setText("jMenuItem1");
        device9Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device9RemoveMousePressed(evt);
            }
        });
        device9Menu.add(device9Remove);

        device9Edit.setText("jMenuItem1");
        device9Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device9EditMousePressed(evt);
            }
        });
        device9Menu.add(device9Edit);

        device9ClearAll.setText("jMenuItem1");
        device9ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device9ClearAllMousePressed(evt);
            }
        });
        device9Menu.add(device9ClearAll);

        device10Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device10MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device10Add.setText("jMenuItem1");
        device10Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device10AddMousePressed(evt);
            }
        });
        device10Menu.add(device10Add);

        device10Remove.setText("jMenuItem1");
        device10Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device10RemoveMousePressed(evt);
            }
        });
        device10Menu.add(device10Remove);

        device10Edit.setText("jMenuItem1");
        device10Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device10EditMousePressed(evt);
            }
        });
        device10Menu.add(device10Edit);

        device10ClearAll.setText("jMenuItem1");
        device10ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device10ClearAllMousePressed(evt);
            }
        });
        device10Menu.add(device10ClearAll);

        device11Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device11MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device11Add.setText("jMenuItem1");
        device11Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device11AddMousePressed(evt);
            }
        });
        device11Menu.add(device11Add);

        device11Remove.setText("jMenuItem1");
        device11Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device11RemoveMousePressed(evt);
            }
        });
        device11Menu.add(device11Remove);

        device11Edit.setText("jMenuItem1");
        device11Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device11EditMousePressed(evt);
            }
        });
        device11Menu.add(device11Edit);

        device11ClearAll.setText("jMenuItem1");
        device11ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device11ClearAllMousePressed(evt);
            }
        });
        device11Menu.add(device11ClearAll);

        device12Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device12MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device12Add.setText("jMenuItem1");
        device12Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device12AddMousePressed(evt);
            }
        });
        device12Menu.add(device12Add);

        device12Remove.setText("jMenuItem1");
        device12Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device12RemoveMousePressed(evt);
            }
        });
        device12Menu.add(device12Remove);

        device12Edit.setText("jMenuItem1");
        device12Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device12EditMousePressed(evt);
            }
        });
        device12Menu.add(device12Edit);

        device12ClearAll.setText("jMenuItem1");
        device12ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device12ClearAllMousePressed(evt);
            }
        });
        device12Menu.add(device12ClearAll);

        device13Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device13MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device13Add.setText("jMenuItem1");
        device13Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device13AddMousePressed(evt);
            }
        });
        device13Menu.add(device13Add);

        device13Remove.setText("jMenuItem1");
        device13Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device13RemoveMousePressed(evt);
            }
        });
        device13Menu.add(device13Remove);

        device13Edit.setText("jMenuItem1");
        device13Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device13EditMousePressed(evt);
            }
        });
        device13Menu.add(device13Edit);

        device13ClearAll.setText("jMenuItem1");
        device13ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device13ClearAllMousePressed(evt);
            }
        });
        device13Menu.add(device13ClearAll);

        device14Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device14MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device14Add.setText("jMenuItem1");
        device14Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device14AddMousePressed(evt);
            }
        });
        device14Menu.add(device14Add);

        device14Remove.setText("jMenuItem1");
        device14Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device14RemoveMousePressed(evt);
            }
        });
        device14Menu.add(device14Remove);

        device14Edit.setText("jMenuItem1");
        device14Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device14EditMousePressed(evt);
            }
        });
        device14Menu.add(device14Edit);

        device14ClearAll.setText("jMenuItem1");
        device14ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device14ClearAllMousePressed(evt);
            }
        });
        device14Menu.add(device14ClearAll);

        device15Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device15MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device15Add.setText("jMenuItem1");
        device15Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device15AddMousePressed(evt);
            }
        });
        device15Menu.add(device15Add);

        device15Remove.setText("jMenuItem1");
        device15Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device15RemoveMousePressed(evt);
            }
        });
        device15Menu.add(device15Remove);

        device15Edit.setText("jMenuItem1");
        device15Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device15EditMousePressed(evt);
            }
        });
        device15Menu.add(device15Edit);

        device15ClearAll.setText("jMenuItem1");
        device15ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device15ClearAllMousePressed(evt);
            }
        });
        device15Menu.add(device15ClearAll);

        device16Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device16MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device16Add.setText("jMenuItem1");
        device16Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device16AddMousePressed(evt);
            }
        });
        device16Menu.add(device16Add);

        device16Remove.setText("jMenuItem1");
        device16Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device16RemoveMousePressed(evt);
            }
        });
        device16Menu.add(device16Remove);

        device16Edit.setText("jMenuItem1");
        device16Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device16EditMousePressed(evt);
            }
        });
        device16Menu.add(device16Edit);

        device16ClearAll.setText("jMenuItem1");
        device16ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device16ClearAllMousePressed(evt);
            }
        });
        device16Menu.add(device16ClearAll);

        device17Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device17MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device17Add.setText("jMenuItem1");
        device17Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device17AddMousePressed(evt);
            }
        });
        device17Menu.add(device17Add);

        device17Remove.setText("jMenuItem1");
        device17Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device17RemoveMousePressed(evt);
            }
        });
        device17Menu.add(device17Remove);

        device17Edit.setText("jMenuItem1");
        device17Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device17EditMousePressed(evt);
            }
        });
        device17Menu.add(device17Edit);

        device17ClearAll.setText("jMenuItem1");
        device17ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device17ClearAllMousePressed(evt);
            }
        });
        device17Menu.add(device17ClearAll);

        device18Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device18MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device18Add.setText("jMenuItem1");
        device18Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device18AddMousePressed(evt);
            }
        });
        device18Menu.add(device18Add);

        device18Remove.setText("jMenuItem1");
        device18Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device18RemoveMousePressed(evt);
            }
        });
        device18Menu.add(device18Remove);

        device18Edit.setText("jMenuItem1");
        device18Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device18EditMousePressed(evt);
            }
        });
        device18Menu.add(device18Edit);

        device18ClearAll.setText("jMenuItem1");
        device18ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device18ClearAllMousePressed(evt);
            }
        });
        device18Menu.add(device18ClearAll);

        device19Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device19MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device19Add.setText("jMenuItem1");
        device19Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device19AddMousePressed(evt);
            }
        });
        device19Menu.add(device19Add);

        device19Remove.setText("jMenuItem1");
        device19Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device19RemoveMousePressed(evt);
            }
        });
        device19Menu.add(device19Remove);

        device19Edit.setText("jMenuItem1");
        device19Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device19EditMousePressed(evt);
            }
        });
        device19Menu.add(device19Edit);

        device19ClearAll.setText("jMenuItem1");
        device19ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device19ClearAllMousePressed(evt);
            }
        });
        device19Menu.add(device19ClearAll);

        device20Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device20MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device20Add.setText("jMenuItem1");
        device20Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device20AddMousePressed(evt);
            }
        });
        device20Menu.add(device20Add);

        device20Remove.setText("jMenuItem1");
        device20Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device20RemoveMousePressed(evt);
            }
        });
        device20Menu.add(device20Remove);

        device20Edit.setText("jMenuItem1");
        device20Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device20EditMousePressed(evt);
            }
        });
        device20Menu.add(device20Edit);

        device20ClearAll.setText("jMenuItem1");
        device20ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device20ClearAllMousePressed(evt);
            }
        });
        device20Menu.add(device20ClearAll);

        device21Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device21MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device21Add.setText("jMenuItem1");
        device21Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device21AddMousePressed(evt);
            }
        });
        device21Menu.add(device21Add);

        device21Remove.setText("jMenuItem1");
        device21Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device21RemoveMousePressed(evt);
            }
        });
        device21Menu.add(device21Remove);

        device21Edit.setText("jMenuItem1");
        device21Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device21EditMousePressed(evt);
            }
        });
        device21Menu.add(device21Edit);

        device21ClearAll.setText("jMenuItem1");
        device21ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device21ClearAllMousePressed(evt);
            }
        });
        device21Menu.add(device21ClearAll);

        device22Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device22MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device22Add.setText("jMenuItem1");
        device22Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device22AddMousePressed(evt);
            }
        });
        device22Menu.add(device22Add);

        device22Remove.setText("jMenuItem1");
        device22Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device22RemoveMousePressed(evt);
            }
        });
        device22Menu.add(device22Remove);

        device22Edit.setText("jMenuItem1");
        device22Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device22EditMousePressed(evt);
            }
        });
        device22Menu.add(device22Edit);

        device22ClearAll.setText("jMenuItem1");
        device22ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device22ClearAllMousePressed(evt);
            }
        });
        device22Menu.add(device22ClearAll);

        device23Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device23MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device23Add.setText("jMenuItem1");
        device23Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device23AddMousePressed(evt);
            }
        });
        device23Menu.add(device23Add);

        device23Remove.setText("jMenuItem1");
        device23Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device23RemoveMousePressed(evt);
            }
        });
        device23Menu.add(device23Remove);

        device23Edit.setText("jMenuItem1");
        device23Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device23EditMousePressed(evt);
            }
        });
        device23Menu.add(device23Edit);

        device23ClearAll.setText("jMenuItem1");
        device23ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device23ClearAllMousePressed(evt);
            }
        });
        device23Menu.add(device23ClearAll);

        device24Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device24MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device24Add.setText("jMenuItem1");
        device24Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device24AddMousePressed(evt);
            }
        });
        device24Menu.add(device24Add);

        device24Remove.setText("jMenuItem1");
        device24Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device24RemoveMousePressed(evt);
            }
        });
        device24Menu.add(device24Remove);

        device24Edit.setText("jMenuItem1");
        device24Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device24EditMousePressed(evt);
            }
        });
        device24Menu.add(device24Edit);

        device24ClearAll.setText("jMenuItem1");
        device24ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device24ClearAllMousePressed(evt);
            }
        });
        device24Menu.add(device24ClearAll);

        device25Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device25MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device25Add.setText("jMenuItem1");
        device25Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device25AddMousePressed(evt);
            }
        });
        device25Menu.add(device25Add);

        device25Remove.setText("jMenuItem1");
        device25Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device25RemoveMousePressed(evt);
            }
        });
        device25Menu.add(device25Remove);

        device25Edit.setText("jMenuItem1");
        device25Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device25EditMousePressed(evt);
            }
        });
        device25Menu.add(device25Edit);

        device25ClearAll.setText("jMenuItem1");
        device25ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device25ClearAllMousePressed(evt);
            }
        });
        device25Menu.add(device25ClearAll);

        device26Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device26MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device26Add.setText("jMenuItem1");
        device26Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device26AddMousePressed(evt);
            }
        });
        device26Menu.add(device26Add);

        device26Remove.setText("jMenuItem1");
        device26Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device26RemoveMousePressed(evt);
            }
        });
        device26Menu.add(device26Remove);

        device26Edit.setText("jMenuItem1");
        device26Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device26EditMousePressed(evt);
            }
        });
        device26Menu.add(device26Edit);

        device26ClearAll.setText("jMenuItem1");
        device26ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device26ClearAllMousePressed(evt);
            }
        });
        device26Menu.add(device26ClearAll);

        device27Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device27MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device27Add.setText("jMenuItem1");
        device27Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device27AddMousePressed(evt);
            }
        });
        device27Menu.add(device27Add);

        device27Remove.setText("jMenuItem1");
        device27Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device27RemoveMousePressed(evt);
            }
        });
        device27Menu.add(device27Remove);

        device27Edit.setText("jMenuItem1");
        device27Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device27EditMousePressed(evt);
            }
        });
        device27Menu.add(device27Edit);

        device27ClearAll.setText("jMenuItem1");
        device27ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device27ClearAllMousePressed(evt);
            }
        });
        device27Menu.add(device27ClearAll);

        device28Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device28MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device28Add.setText("jMenuItem1");
        device28Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device28AddMousePressed(evt);
            }
        });
        device28Menu.add(device28Add);

        device28Remove.setText("jMenuItem1");
        device28Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device28RemoveMousePressed(evt);
            }
        });
        device28Menu.add(device28Remove);

        device28Edit.setText("jMenuItem1");
        device28Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device28EditMousePressed(evt);
            }
        });
        device28Menu.add(device28Edit);

        device28ClearAll.setText("jMenuItem1");
        device28ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device28ClearAllMousePressed(evt);
            }
        });
        device28Menu.add(device28ClearAll);

        device29Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device29MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device29Add.setText("jMenuItem1");
        device29Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device29AddMousePressed(evt);
            }
        });
        device29Menu.add(device29Add);

        device29Remove.setText("jMenuItem1");
        device29Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device29RemoveMousePressed(evt);
            }
        });
        device29Menu.add(device29Remove);

        device29Edit.setText("jMenuItem1");
        device29Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device29EditMousePressed(evt);
            }
        });
        device29Menu.add(device29Edit);

        device29ClearAll.setText("jMenuItem1");
        device29ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device29ClearAllMousePressed(evt);
            }
        });
        device29Menu.add(device29ClearAll);

        device30Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device30MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device30Add.setText("jMenuItem1");
        device30Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device30AddMousePressed(evt);
            }
        });
        device30Menu.add(device30Add);

        device30Remove.setText("jMenuItem1");
        device30Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device30RemoveMousePressed(evt);
            }
        });
        device30Menu.add(device30Remove);

        device30Edit.setText("jMenuItem1");
        device30Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device30EditMousePressed(evt);
            }
        });
        device30Menu.add(device30Edit);

        device30ClearAll.setText("jMenuItem1");
        device30ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device30ClearAllMousePressed(evt);
            }
        });
        device30Menu.add(device30ClearAll);

        device31Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device31MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device31Add.setText("jMenuItem1");
        device31Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device31AddMousePressed(evt);
            }
        });
        device31Menu.add(device31Add);

        device31Remove.setText("jMenuItem1");
        device31Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device31RemoveMousePressed(evt);
            }
        });
        device31Menu.add(device31Remove);

        device31Edit.setText("jMenuItem1");
        device31Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device31EditMousePressed(evt);
            }
        });
        device31Menu.add(device31Edit);

        device31ClearAll.setText("jMenuItem1");
        device31ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device31ClearAllMousePressed(evt);
            }
        });
        device31ClearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                device31ClearAllActionPerformed(evt);
            }
        });
        device31Menu.add(device31ClearAll);

        device32Menu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                device32MenuPopupMenuWillBecomeVisible(evt);
            }
        });

        device32Add.setText("jMenuItem1");
        device32Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device32AddMousePressed(evt);
            }
        });
        device32Menu.add(device32Add);

        device32Remove.setText("jMenuItem1");
        device32Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device32RemoveMousePressed(evt);
            }
        });
        device32Menu.add(device32Remove);

        device32Edit.setText("jMenuItem1");
        device32Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device32EditMousePressed(evt);
            }
        });
        device32Menu.add(device32Edit);

        device32ClearAll.setText("jMenuItem1");
        device32ClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                device32ClearAllMousePressed(evt);
            }
        });
        device32Menu.add(device32ClearAll);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane1.addTab("About", jTabbedPane3);

        sensorViewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Arduino", "MAC", "Pin", "Description"
            }
        ));
        sensorViewTable.setComponentPopupMenu(sensorMenu);
        sensorViewTable.setName(""); // NOI18N
        jScrollPane1.setViewportView(sensorViewTable);

        jTabbedPane4.addTab("Sensors", jScrollPane1);

        optionsViewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Type", "If", "Sensor", "Device", "Date", "Time", "Value", "Description"
            }
        ));
        jScrollPane2.setViewportView(optionsViewTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1037, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
        );

        jTabbedPane4.addTab("Options", jPanel1);

        devicesViewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Description", "Arduino", "Pin"
            }
        ));
        devicesViewTable.setComponentPopupMenu(deviceMenu);
        jScrollPane3.setViewportView(devicesViewTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1037, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
        );

        jTabbedPane4.addTab("Devices", jPanel2);

        ArduinoDeviceViewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Description", "Token", "Ip"
            }
        ));
        ArduinoDeviceViewTable.setComponentPopupMenu(arduinoMenu);
        jScrollPane4.setViewportView(ArduinoDeviceViewTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1037, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
        );

        jTabbedPane4.addTab("Arduino", jPanel3);

        CamersViewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "URL", "Title", "Path"
            }
        ));
        CamersViewTable.setComponentPopupMenu(cameraMenu);
        jScrollPane5.setViewportView(CamersViewTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1037, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
        );

        jTabbedPane4.addTab("Camers", jPanel4);

        jTabbedPane1.addTab("Options", jTabbedPane4);

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jTabbedPane7.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        device1Panel.setComponentPopupMenu(device1Menu);

        jScrollPane22.setComponentPopupMenu(device1Menu);

        device1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device1.setComponentPopupMenu(device1Menu);
        device1.setInheritsPopupMenu(true);
        jScrollPane22.setViewportView(device1);

        javax.swing.GroupLayout device1PanelLayout = new javax.swing.GroupLayout(device1Panel);
        device1Panel.setLayout(device1PanelLayout);
        device1PanelLayout.setHorizontalGroup(
            device1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
        );
        device1PanelLayout.setVerticalGroup(
            device1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane7.addTab("Device 1", device1Panel);

        device2Panel.setComponentPopupMenu(device2Menu);

        device2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device2.setComponentPopupMenu(device2Menu);
        jScrollPane23.setViewportView(device2);

        javax.swing.GroupLayout device2PanelLayout = new javax.swing.GroupLayout(device2Panel);
        device2Panel.setLayout(device2PanelLayout);
        device2PanelLayout.setHorizontalGroup(
            device2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
        );
        device2PanelLayout.setVerticalGroup(
            device2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane7.addTab("Device 2", device2Panel);

        device3Panel.setComponentPopupMenu(device3Menu);

        device3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device3.setComponentPopupMenu(device3Menu);
        jScrollPane24.setViewportView(device3);

        javax.swing.GroupLayout device3PanelLayout = new javax.swing.GroupLayout(device3Panel);
        device3Panel.setLayout(device3PanelLayout);
        device3PanelLayout.setHorizontalGroup(
            device3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane24, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
        );
        device3PanelLayout.setVerticalGroup(
            device3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane24, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane7.addTab("Device 3", device3Panel);

        device4Panel.setComponentPopupMenu(device4Menu);

        device4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device4.setComponentPopupMenu(device4Menu);
        jScrollPane25.setViewportView(device4);

        javax.swing.GroupLayout device4PanelLayout = new javax.swing.GroupLayout(device4Panel);
        device4Panel.setLayout(device4PanelLayout);
        device4PanelLayout.setHorizontalGroup(
            device4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane25, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
        );
        device4PanelLayout.setVerticalGroup(
            device4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane25, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane7.addTab("Device 4", device4Panel);

        device5Panel.setComponentPopupMenu(device5Menu);

        device5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device5.setComponentPopupMenu(device5Menu);
        jScrollPane26.setViewportView(device5);

        javax.swing.GroupLayout device5PanelLayout = new javax.swing.GroupLayout(device5Panel);
        device5Panel.setLayout(device5PanelLayout);
        device5PanelLayout.setHorizontalGroup(
            device5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane26, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
        );
        device5PanelLayout.setVerticalGroup(
            device5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane26, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane7.addTab("Device 5", device5Panel);

        device6Panel.setComponentPopupMenu(device6Menu);

        device6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device6.setComponentPopupMenu(device6Menu);
        jScrollPane27.setViewportView(device6);

        javax.swing.GroupLayout device6PanelLayout = new javax.swing.GroupLayout(device6Panel);
        device6Panel.setLayout(device6PanelLayout);
        device6PanelLayout.setHorizontalGroup(
            device6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane27, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
        );
        device6PanelLayout.setVerticalGroup(
            device6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane27, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane7.addTab("Device 6", device6Panel);

        device7Panel.setComponentPopupMenu(device7Menu);

        device7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device7.setComponentPopupMenu(device7Menu);
        jScrollPane28.setViewportView(device7);

        javax.swing.GroupLayout device7PanelLayout = new javax.swing.GroupLayout(device7Panel);
        device7Panel.setLayout(device7PanelLayout);
        device7PanelLayout.setHorizontalGroup(
            device7PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane28, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
        );
        device7PanelLayout.setVerticalGroup(
            device7PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane28, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane7.addTab("Device 7", device7Panel);

        device8Panel.setComponentPopupMenu(device8Menu);

        device8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device8.setComponentPopupMenu(device8Menu);
        jScrollPane29.setViewportView(device8);

        javax.swing.GroupLayout device8PanelLayout = new javax.swing.GroupLayout(device8Panel);
        device8Panel.setLayout(device8PanelLayout);
        device8PanelLayout.setHorizontalGroup(
            device8PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane29, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
        );
        device8PanelLayout.setVerticalGroup(
            device8PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane29, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane7.addTab("Device 8", device8Panel);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane7)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane7)
        );

        jTabbedPane2.addTab("Device 1-8", jPanel5);

        jTabbedPane8.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        device9Panel.setComponentPopupMenu(device9Menu);

        device9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device9.setComponentPopupMenu(device9Menu);
        jScrollPane14.setViewportView(device9);

        javax.swing.GroupLayout device9PanelLayout = new javax.swing.GroupLayout(device9Panel);
        device9Panel.setLayout(device9PanelLayout);
        device9PanelLayout.setHorizontalGroup(
            device9PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(device9PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
                .addContainerGap())
        );
        device9PanelLayout.setVerticalGroup(
            device9PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane8.addTab("Device 9", device9Panel);

        device10Panel.setComponentPopupMenu(device10Menu);

        device10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device10.setComponentPopupMenu(device10Menu);
        jScrollPane15.setViewportView(device10);

        javax.swing.GroupLayout device10PanelLayout = new javax.swing.GroupLayout(device10Panel);
        device10Panel.setLayout(device10PanelLayout);
        device10PanelLayout.setHorizontalGroup(
            device10PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        device10PanelLayout.setVerticalGroup(
            device10PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane8.addTab("Device 10", device10Panel);

        jPanel25.setComponentPopupMenu(device11Menu);

        device11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device11.setComponentPopupMenu(device11Menu);
        jScrollPane16.setViewportView(device11);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane8.addTab("Device 11", jPanel25);

        jPanel26.setComponentPopupMenu(device12Menu);

        device12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device12.setComponentPopupMenu(device12Menu);
        jScrollPane17.setViewportView(device12);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane8.addTab("Device 12", jPanel26);

        jPanel27.setComponentPopupMenu(device13Menu);

        device13.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device13.setComponentPopupMenu(device13Menu);
        jScrollPane18.setViewportView(device13);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane8.addTab("Device 13", jPanel27);

        jPanel28.setComponentPopupMenu(device14Menu);

        device14.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device14.setComponentPopupMenu(device14Menu);
        jScrollPane19.setViewportView(device14);

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane8.addTab("Device 14", jPanel28);

        jPanel29.setComponentPopupMenu(device15Menu);

        device15.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device15.setComponentPopupMenu(device15Menu);
        jScrollPane20.setViewportView(device15);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane8.addTab("Device 15", jPanel29);

        jPanel30.setComponentPopupMenu(device16Menu);

        device16.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device16.setComponentPopupMenu(device16Menu);
        jScrollPane21.setViewportView(device16);

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane8.addTab("Device 16", jPanel30);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane8)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane8)
        );

        jTabbedPane2.addTab("Device 9-16", jPanel6);

        jTabbedPane9.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel31.setComponentPopupMenu(device17Menu);

        device17.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device17.setComponentPopupMenu(device17Menu);
        jScrollPane6.setViewportView(device17);

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane9.addTab("Device 17", jPanel31);

        jPanel32.setComponentPopupMenu(device18Menu);

        device18.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        device18.setComponentPopupMenu(device18Menu);
        jScrollPane7.setViewportView(device18);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane9.addTab("Device 18", jPanel32);

        jPanel33.setComponentPopupMenu(device19Menu);

        device19.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device19.setComponentPopupMenu(device19Menu);
        jScrollPane8.setViewportView(device19);

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane9.addTab("Device 19", jPanel33);

        jPanel34.setComponentPopupMenu(device20Menu);

        device20.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device20.setComponentPopupMenu(device20Menu);
        jScrollPane9.setViewportView(device20);

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane9.addTab("Device 20", jPanel34);

        jPanel35.setComponentPopupMenu(device21Menu);

        device21.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device21.setComponentPopupMenu(device21Menu);
        jScrollPane10.setViewportView(device21);

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane9.addTab("Device 21", jPanel35);

        jPanel36.setComponentPopupMenu(device22Menu);

        device22.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device22.setComponentPopupMenu(device22Menu);
        jScrollPane11.setViewportView(device22);

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane9.addTab("Device 22", jPanel36);

        jPanel37.setComponentPopupMenu(device23Menu);

        device23.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device23.setComponentPopupMenu(device23Menu);
        jScrollPane12.setViewportView(device23);

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane9.addTab("Device 23", jPanel37);

        jPanel38.setComponentPopupMenu(device24Menu);

        device24.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device24.setComponentPopupMenu(device24Menu);
        jScrollPane13.setViewportView(device24);

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane9.addTab("Device 24", jPanel38);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane9)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane9)
        );

        jTabbedPane2.addTab("Device 17-24", jPanel7);

        jTabbedPane10.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel40.setComponentPopupMenu(device25Menu);

        device25.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device25.setComponentPopupMenu(device25Menu);
        jScrollPane30.setViewportView(device25);

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane30, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane30, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane10.addTab("Device 25", jPanel40);

        jPanel41.setComponentPopupMenu(device26Menu);

        device26.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device26.setComponentPopupMenu(device26Menu);
        jScrollPane31.setViewportView(device26);

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane31, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane31, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane10.addTab("Device 26", jPanel41);

        jPanel42.setComponentPopupMenu(device27Menu);

        device27.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device27.setComponentPopupMenu(device27Menu);
        jScrollPane32.setViewportView(device27);

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane32, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane32, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane10.addTab("Device 27", jPanel42);

        jPanel43.setComponentPopupMenu(device28Menu);

        device28.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device28.setComponentPopupMenu(device28Menu);
        jScrollPane33.setViewportView(device28);

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane33, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane33, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane10.addTab("Device 28", jPanel43);

        jPanel44.setComponentPopupMenu(device29Menu);

        device29.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device29.setComponentPopupMenu(device29Menu);
        jScrollPane34.setViewportView(device29);

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane34, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane34, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane10.addTab("Device 29", jPanel44);

        jPanel45.setComponentPopupMenu(device30Menu);

        device30.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device30.setComponentPopupMenu(device30Menu);
        jScrollPane35.setViewportView(device30);

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane35, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane35, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane10.addTab("Device 30", jPanel45);

        jPanel46.setComponentPopupMenu(device31Menu);

        device31.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device31.setComponentPopupMenu(device31Menu);
        jScrollPane36.setViewportView(device31);

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane36, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane36, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane10.addTab("Device 31", jPanel46);

        jPanel47.setComponentPopupMenu(device32Menu);

        device32.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        device32.setComponentPopupMenu(device32Menu);
        jScrollPane37.setViewportView(device32);

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane37, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane37, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        jTabbedPane10.addTab("Device 32", jPanel47);

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane10)
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane10)
        );

        jTabbedPane2.addTab("Device 25-32", jPanel39);

        jTabbedPane1.addTab("Data", jTabbedPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void device1EditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device1EditMouseClicked

    }//GEN-LAST:event_device1EditMouseClicked


    private void device1EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device1EditMousePressed
        editOption(device1);
    }//GEN-LAST:event_device1EditMousePressed

    private void addOption(JTable jTable) {
        NewOptionDialog newOptionDialog = new NewOptionDialog(this, rootPaneCheckingEnabled, jTable);
        newOptionDialog.device = jTable.getToolTipText();
        newOptionDialog.setVisible(true);
    }

    private void editOption(JTable jTable) {
        if (jTable.getSelectedRow() >= 0) {
            EditOptionDialog jDialog = new EditOptionDialog(this, rootPaneCheckingEnabled, jTable.getValueAt(jTable.getSelectedRow(), 0).toString());
            jDialog.setVisible(true);
            OptionProvider optionProvider = new OptionProvider();
            optionProvider.load(jTable, jTable.getToolTipText());
        } else {
            JOptionPane.showMessageDialog(null, "No selected option", jTable.getToolTipText(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeOption(JTable jTable) throws HeadlessException {
        if (jTable.getSelectedRow() >= 0) {
            if (JOptionPane.showConfirmDialog(rootPane, "Delete option?", "SMART", YES_NO_OPTION) == 0) {
            try {
                OptionProvider optionProvider = new OptionProvider();
                optionProvider.deleteByName(jTable.getValueAt(jTable.getSelectedRow(), jTable.getSelectedColumn()).toString());
                DefaultTableModel model = (DefaultTableModel) jTable.getModel();
                model.removeRow(jTable.getSelectedRow());
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (URISyntaxException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No selected option", jTable.getToolTipText(), JOptionPane.ERROR_MESSAGE);
        }
        
    }


    private void device1AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device1AddMousePressed
        addOption(device1);
    }//GEN-LAST:event_device1AddMousePressed

    private void device1RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device1RemoveMousePressed
        removeOption(device1);
    }//GEN-LAST:event_device1RemoveMousePressed

    private void addArduinoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addArduinoMousePressed
        NewArduinoDialog arduinoDialog = new NewArduinoDialog(this, rootPaneCheckingEnabled);
        arduinoDialog.setVisible(true);
    }//GEN-LAST:event_addArduinoMousePressed

    private void editArduinoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editArduinoMousePressed
        EditArduinoDialog arduinoDialog = new EditArduinoDialog(this, rootPaneCheckingEnabled, ArduinoDeviceViewTable.getValueAt(ArduinoDeviceViewTable.getSelectedRow(),
                0).toString());
        arduinoDialog.setVisible(true);
    }//GEN-LAST:event_editArduinoMousePressed

    private void addDeviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDeviceActionPerformed
        NewDeviceDialog newDeviceDialog = new NewDeviceDialog(this, rootPaneCheckingEnabled);
        newDeviceDialog.setVisible(true);
    }//GEN-LAST:event_addDeviceActionPerformed

    private void editDeviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDeviceActionPerformed
        EditDeviceDialog editDeviceDialog = new EditDeviceDialog(this, rootPaneCheckingEnabled, devicesViewTable.getValueAt(devicesViewTable.getSelectedRow(),
                0).toString());
        editDeviceDialog.setVisible(true);
    }//GEN-LAST:event_editDeviceActionPerformed

    private void device1AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_device1AddActionPerformed

    }//GEN-LAST:event_device1AddActionPerformed

    private void addSensorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addSensorMousePressed
        NewSensorDialog newSensorDialog = new NewSensorDialog(this, rootPaneCheckingEnabled);
        newSensorDialog.setVisible(true);
    }//GEN-LAST:event_addSensorMousePressed

    private void editSensorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editSensorMousePressed
        EditSensorDialog editSensorDialog = new EditSensorDialog(this, rootPaneCheckingEnabled, sensorViewTable.getValueAt(sensorViewTable.getSelectedRow(),
                0).toString());
        editSensorDialog.setVisible(true);
    }//GEN-LAST:event_editSensorMousePressed

    private void addCameraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addCameraMousePressed
        NewCameraDialog newCameraDialog = new NewCameraDialog(this, rootPaneCheckingEnabled);
        newCameraDialog.setVisible(true);
    }//GEN-LAST:event_addCameraMousePressed

    private void editCameraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editCameraMousePressed
        EditCameraDialog editCameraDialog = new EditCameraDialog(this, rootPaneCheckingEnabled, CamersViewTable.getValueAt(CamersViewTable.getSelectedRow(),
                0).toString());
        editCameraDialog.setVisible(true);
    }//GEN-LAST:event_editCameraMousePressed

    private void addDeviceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addDeviceMousePressed
        NewDeviceDialog newDeviceDialog = new NewDeviceDialog(this, rootPaneCheckingEnabled);
        newDeviceDialog.setVisible(true);
    }//GEN-LAST:event_addDeviceMousePressed

    private void editDeviceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editDeviceMousePressed
        EditDeviceDialog editDeviceDialog = new EditDeviceDialog(this, rootPaneCheckingEnabled, devicesViewTable.getValueAt(devicesViewTable.getSelectedRow(),
                0).toString());
        editDeviceDialog.setVisible(true);
    }//GEN-LAST:event_editDeviceMousePressed

    private void device1MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device1MenuPopupMenuWillBecomeVisible
        //System.out.println("PopUpMenu -> Device1 -> Open");
        if (device1.getRowCount() == 0) {
            device1Edit.setVisible(false);
            device1Remove.setVisible(false);
            device1ClearAll.setVisible(false);
        } else {
            device1Edit.setVisible(true);
            device1Remove.setVisible(true);
            device1ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device1MenuPopupMenuWillBecomeVisible

    private void device2AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device2AddMousePressed
        addOption(device2);
    }//GEN-LAST:event_device2AddMousePressed

    private void device2RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device2RemoveMousePressed
        removeOption(device2);
    }//GEN-LAST:event_device2RemoveMousePressed

    private void device2EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device2EditMousePressed
        editOption(device2);
    }//GEN-LAST:event_device2EditMousePressed

    private void device3AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device3AddMousePressed
        addOption(device3);
    }//GEN-LAST:event_device3AddMousePressed

    private void device4AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device4AddMousePressed
        addOption(device4);
    }//GEN-LAST:event_device4AddMousePressed

    private void device5AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device5AddMousePressed
        addOption(device5);
    }//GEN-LAST:event_device5AddMousePressed

    private void device6AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device6AddMousePressed
        addOption(device6);
    }//GEN-LAST:event_device6AddMousePressed

    private void device7AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device7AddMousePressed
        addOption(device7);
    }//GEN-LAST:event_device7AddMousePressed

    private void device8AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device8AddMousePressed
        addOption(device8);
    }//GEN-LAST:event_device8AddMousePressed

    private void device9AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device9AddMousePressed
        addOption(device9);
    }//GEN-LAST:event_device9AddMousePressed

    private void device10AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device10AddMousePressed
        addOption(device10);
    }//GEN-LAST:event_device10AddMousePressed

    private void device11AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device11AddMousePressed
        addOption(device11);
    }//GEN-LAST:event_device11AddMousePressed

    private void device12AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device12AddMousePressed
        addOption(device12);
    }//GEN-LAST:event_device12AddMousePressed

    private void device13AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device13AddMousePressed
        addOption(device13);
    }//GEN-LAST:event_device13AddMousePressed

    private void device14AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device14AddMousePressed
        addOption(device14);
    }//GEN-LAST:event_device14AddMousePressed

    private void device15AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device15AddMousePressed
        addOption(device15);
    }//GEN-LAST:event_device15AddMousePressed

    private void device16AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device16AddMousePressed
        addOption(device16);
    }//GEN-LAST:event_device16AddMousePressed

    private void device17AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device17AddMousePressed
        addOption(device17);
    }//GEN-LAST:event_device17AddMousePressed

    private void device18AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device18AddMousePressed
        addOption(device18);
    }//GEN-LAST:event_device18AddMousePressed

    private void device19AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device19AddMousePressed
        addOption(device19);
    }//GEN-LAST:event_device19AddMousePressed

    private void device20AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device20AddMousePressed
        addOption(device20);
    }//GEN-LAST:event_device20AddMousePressed

    private void device21AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device21AddMousePressed
        addOption(device21);
    }//GEN-LAST:event_device21AddMousePressed

    private void device22AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device22AddMousePressed
        addOption(device22);
    }//GEN-LAST:event_device22AddMousePressed

    private void device23AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device23AddMousePressed
        addOption(device23);
    }//GEN-LAST:event_device23AddMousePressed

    private void device24AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device24AddMousePressed
        addOption(device24);
    }//GEN-LAST:event_device24AddMousePressed

    private void device25AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device25AddMousePressed
        addOption(device25);
    }//GEN-LAST:event_device25AddMousePressed

    private void device26AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device26AddMousePressed
        addOption(device26);
    }//GEN-LAST:event_device26AddMousePressed

    private void device27AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device27AddMousePressed
        addOption(device27);
    }//GEN-LAST:event_device27AddMousePressed

    private void device28AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device28AddMousePressed
        addOption(device28);
    }//GEN-LAST:event_device28AddMousePressed

    private void device29AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device29AddMousePressed
        addOption(device29);
    }//GEN-LAST:event_device29AddMousePressed

    private void device30AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device30AddMousePressed
        addOption(device30);
    }//GEN-LAST:event_device30AddMousePressed

    private void device31AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device31AddMousePressed
        addOption(device31);
    }//GEN-LAST:event_device31AddMousePressed

    private void device32AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device32AddMousePressed
        addOption(device32);
    }//GEN-LAST:event_device32AddMousePressed

    private void device3RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device3RemoveMousePressed
        removeOption(device3);
    }//GEN-LAST:event_device3RemoveMousePressed

    private void device4RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device4RemoveMousePressed
        removeOption(device4);
    }//GEN-LAST:event_device4RemoveMousePressed

    private void device5RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device5RemoveMousePressed
        removeOption(device5);
    }//GEN-LAST:event_device5RemoveMousePressed

    private void device6RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device6RemoveMousePressed
        removeOption(device6);
    }//GEN-LAST:event_device6RemoveMousePressed

    private void device7RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device7RemoveMousePressed
        removeOption(device7);
    }//GEN-LAST:event_device7RemoveMousePressed

    private void device8RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device8RemoveMousePressed
        removeOption(device8);
    }//GEN-LAST:event_device8RemoveMousePressed

    private void device9RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device9RemoveMousePressed
        removeOption(device9);
    }//GEN-LAST:event_device9RemoveMousePressed

    private void device10RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device10RemoveMousePressed
        removeOption(device10);
    }//GEN-LAST:event_device10RemoveMousePressed

    private void device11RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device11RemoveMousePressed
        removeOption(device11);
    }//GEN-LAST:event_device11RemoveMousePressed

    private void device12RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device12RemoveMousePressed
        removeOption(device12);
    }//GEN-LAST:event_device12RemoveMousePressed

    private void device13RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device13RemoveMousePressed
        removeOption(device13);
    }//GEN-LAST:event_device13RemoveMousePressed

    private void device14RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device14RemoveMousePressed
        removeOption(device14);
    }//GEN-LAST:event_device14RemoveMousePressed

    private void device15RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device15RemoveMousePressed
        removeOption(device15);
    }//GEN-LAST:event_device15RemoveMousePressed

    private void device16RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device16RemoveMousePressed
        removeOption(device16);
    }//GEN-LAST:event_device16RemoveMousePressed

    private void device17RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device17RemoveMousePressed
        removeOption(device17);
    }//GEN-LAST:event_device17RemoveMousePressed

    private void device18RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device18RemoveMousePressed
        removeOption(device18);
    }//GEN-LAST:event_device18RemoveMousePressed

    private void device19RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device19RemoveMousePressed
        removeOption(device19);
    }//GEN-LAST:event_device19RemoveMousePressed

    private void device20RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device20RemoveMousePressed
        removeOption(device20);
    }//GEN-LAST:event_device20RemoveMousePressed

    private void device21RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device21RemoveMousePressed
        removeOption(device21);
    }//GEN-LAST:event_device21RemoveMousePressed

    private void device22RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device22RemoveMousePressed
        removeOption(device22);
    }//GEN-LAST:event_device22RemoveMousePressed

    private void device23RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device23RemoveMousePressed
        removeOption(device23);
    }//GEN-LAST:event_device23RemoveMousePressed

    private void device24RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device24RemoveMousePressed
        removeOption(device24);
    }//GEN-LAST:event_device24RemoveMousePressed

    private void device25RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device25RemoveMousePressed
        removeOption(device25);
    }//GEN-LAST:event_device25RemoveMousePressed

    private void device26RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device26RemoveMousePressed
        removeOption(device26);
    }//GEN-LAST:event_device26RemoveMousePressed

    private void device27RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device27RemoveMousePressed
        removeOption(device27);
    }//GEN-LAST:event_device27RemoveMousePressed

    private void device28RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device28RemoveMousePressed
        removeOption(device28);
    }//GEN-LAST:event_device28RemoveMousePressed

    private void device29RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device29RemoveMousePressed
        removeOption(device29);
    }//GEN-LAST:event_device29RemoveMousePressed

    private void device30RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device30RemoveMousePressed
        removeOption(device30);
    }//GEN-LAST:event_device30RemoveMousePressed

    private void device31RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device31RemoveMousePressed
        removeOption(device31);
    }//GEN-LAST:event_device31RemoveMousePressed

    private void device32RemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device32RemoveMousePressed
        removeOption(device22);
    }//GEN-LAST:event_device32RemoveMousePressed

    private void device3EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device3EditMousePressed
        editOption(device3);
    }//GEN-LAST:event_device3EditMousePressed

    private void device4EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device4EditMousePressed
        editOption(device4);
    }//GEN-LAST:event_device4EditMousePressed

    private void device5EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device5EditMousePressed
        editOption(device5);
    }//GEN-LAST:event_device5EditMousePressed

    private void device6EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device6EditMousePressed
        editOption(device6);
    }//GEN-LAST:event_device6EditMousePressed

    private void device7EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device7EditMousePressed
        editOption(device7);
    }//GEN-LAST:event_device7EditMousePressed

    private void device8EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device8EditMousePressed
        editOption(device8);
    }//GEN-LAST:event_device8EditMousePressed

    private void device9EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device9EditMousePressed
        editOption(device9);
    }//GEN-LAST:event_device9EditMousePressed

    private void device10EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device10EditMousePressed
        editOption(device10);
    }//GEN-LAST:event_device10EditMousePressed

    private void device11EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device11EditMousePressed
        editOption(device11);
    }//GEN-LAST:event_device11EditMousePressed

    private void device12EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device12EditMousePressed
        editOption(device12);
    }//GEN-LAST:event_device12EditMousePressed

    private void device13EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device13EditMousePressed
        editOption(device13);
    }//GEN-LAST:event_device13EditMousePressed

    private void device14EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device14EditMousePressed
        editOption(device14);
    }//GEN-LAST:event_device14EditMousePressed

    private void device15EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device15EditMousePressed
        editOption(device15);
    }//GEN-LAST:event_device15EditMousePressed

    private void device16EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device16EditMousePressed
        editOption(device16);
    }//GEN-LAST:event_device16EditMousePressed

    private void device17EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device17EditMousePressed
        editOption(device17);
    }//GEN-LAST:event_device17EditMousePressed

    private void device18EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device18EditMousePressed
        editOption(device18);
    }//GEN-LAST:event_device18EditMousePressed

    private void device19EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device19EditMousePressed
        editOption(device19);
    }//GEN-LAST:event_device19EditMousePressed

    private void device20EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device20EditMousePressed
        editOption(device20);
    }//GEN-LAST:event_device20EditMousePressed

    private void device21EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device21EditMousePressed
        editOption(device21);
    }//GEN-LAST:event_device21EditMousePressed

    private void device22EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device22EditMousePressed
        editOption(device22);
    }//GEN-LAST:event_device22EditMousePressed

    private void device23EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device23EditMousePressed
        editOption(device23);
    }//GEN-LAST:event_device23EditMousePressed

    private void device24EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device24EditMousePressed
        editOption(device24);
    }//GEN-LAST:event_device24EditMousePressed

    private void device25EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device25EditMousePressed
        editOption(device25);
    }//GEN-LAST:event_device25EditMousePressed

    private void device26EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device26EditMousePressed
        editOption(device26);
    }//GEN-LAST:event_device26EditMousePressed

    private void device27EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device27EditMousePressed
        editOption(device27);
    }//GEN-LAST:event_device27EditMousePressed

    private void device28EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device28EditMousePressed
        editOption(device28);
    }//GEN-LAST:event_device28EditMousePressed

    private void device29EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device29EditMousePressed
        editOption(device29);
    }//GEN-LAST:event_device29EditMousePressed

    private void device30EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device30EditMousePressed
        editOption(device30);
    }//GEN-LAST:event_device30EditMousePressed

    private void device31EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device31EditMousePressed
        editOption(device31);
    }//GEN-LAST:event_device31EditMousePressed

    private void device32EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device32EditMousePressed
        editOption(device32);
    }//GEN-LAST:event_device32EditMousePressed

    private void device2MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device2MenuPopupMenuWillBecomeVisible
        if (device2.getRowCount() == 0) {
            device2Edit.setVisible(false);
            device2Remove.setVisible(false);
            device2ClearAll.setVisible(false);
        } else {
            device2Edit.setVisible(true);
            device2Remove.setVisible(true);
            device2ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device2MenuPopupMenuWillBecomeVisible

    private void device3MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device3MenuPopupMenuWillBecomeVisible
        if (device3.getRowCount() == 0) {
            device3Edit.setVisible(false);
            device3Remove.setVisible(false);
            device3ClearAll.setVisible(false);
        } else {
            device3Edit.setVisible(true);
            device3Remove.setVisible(true);
            device3ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device3MenuPopupMenuWillBecomeVisible

    private void device4MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device4MenuPopupMenuWillBecomeVisible
        if (device4.getRowCount() == 0) {
            device4Edit.setVisible(false);
            device4Remove.setVisible(false);
            device4ClearAll.setVisible(false);
        } else {
            device4Edit.setVisible(true);
            device4Remove.setVisible(true);
            device4ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device4MenuPopupMenuWillBecomeVisible

    private void device5MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device5MenuPopupMenuWillBecomeVisible
        if (device5.getRowCount() == 0) {
            device5Edit.setVisible(false);
            device5Remove.setVisible(false);
            device5ClearAll.setVisible(false);
        } else {
            device5Edit.setVisible(true);
            device5Remove.setVisible(true);
            device5ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device5MenuPopupMenuWillBecomeVisible

    private void device6MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device6MenuPopupMenuWillBecomeVisible
        if (device6.getRowCount() == 0) {
            device6Edit.setVisible(false);
            device6Remove.setVisible(false);
            device6ClearAll.setVisible(false);
        } else {
            device6Edit.setVisible(true);
            device6Remove.setVisible(true);
            device6ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device6MenuPopupMenuWillBecomeVisible

    private void device7MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device7MenuPopupMenuWillBecomeVisible
        if (device7.getRowCount() == 0) {
            device7Edit.setVisible(false);
            device7Remove.setVisible(false);
            device7ClearAll.setVisible(false);
        } else {
            device7Edit.setVisible(true);
            device7Remove.setVisible(true);
            device7ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device7MenuPopupMenuWillBecomeVisible

    private void device8MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device8MenuPopupMenuWillBecomeVisible
        if (device8.getRowCount() == 0) {
            device8Edit.setVisible(false);
            device8Remove.setVisible(false);
            device8ClearAll.setVisible(false);
        } else {
            device8Edit.setVisible(true);
            device8Remove.setVisible(true);
            device8ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device8MenuPopupMenuWillBecomeVisible

    private void device9MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device9MenuPopupMenuWillBecomeVisible
        if (device9.getRowCount() == 0) {
            device9Edit.setVisible(false);
            device9Remove.setVisible(false);
            device9ClearAll.setVisible(false);
        } else {
            device9Edit.setVisible(true);
            device9Remove.setVisible(true);
            device9ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device9MenuPopupMenuWillBecomeVisible

    private void device10MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device10MenuPopupMenuWillBecomeVisible
        if (device10.getRowCount() == 0) {
            device10Edit.setVisible(false);
            device10Remove.setVisible(false);
            device10ClearAll.setVisible(false);
        } else {
            device10Edit.setVisible(true);
            device10Remove.setVisible(true);
            device10ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device10MenuPopupMenuWillBecomeVisible

    private void device11MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device11MenuPopupMenuWillBecomeVisible
        if (device11.getRowCount() == 0) {
            device11Edit.setVisible(false);
            device11Remove.setVisible(false);
            device11ClearAll.setVisible(false);
        } else {
            device11Edit.setVisible(true);
            device11Remove.setVisible(true);
            device11ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device11MenuPopupMenuWillBecomeVisible

    private void device12MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device12MenuPopupMenuWillBecomeVisible
        if (device12.getRowCount() == 0) {
            device12Edit.setVisible(false);
            device12Remove.setVisible(false);
            device12ClearAll.setVisible(false);
        } else {
            device12Edit.setVisible(true);
            device12Remove.setVisible(true);
            device12ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device12MenuPopupMenuWillBecomeVisible

    private void device13MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device13MenuPopupMenuWillBecomeVisible
        if (device13.getRowCount() == 0) {
            device13Edit.setVisible(false);
            device13Remove.setVisible(false);
            device13ClearAll.setVisible(false);
        } else {
            device13Edit.setVisible(true);
            device13Remove.setVisible(true);
            device13ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device13MenuPopupMenuWillBecomeVisible

    private void device14MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device14MenuPopupMenuWillBecomeVisible
        if (device14.getRowCount() == 0) {
            device14Edit.setVisible(false);
            device14Remove.setVisible(false);
            device14ClearAll.setVisible(false);
        } else {
            device14Edit.setVisible(true);
            device14Remove.setVisible(true);
            device14ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device14MenuPopupMenuWillBecomeVisible

    private void device15MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device15MenuPopupMenuWillBecomeVisible
        if (device15.getRowCount() == 0) {
            device15Edit.setVisible(false);
            device15Remove.setVisible(false);
            device15ClearAll.setVisible(false);
        } else {
            device15Edit.setVisible(true);
            device15Remove.setVisible(true);
            device15ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device15MenuPopupMenuWillBecomeVisible

    private void device16MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device16MenuPopupMenuWillBecomeVisible
        if (device16.getRowCount() == 0) {
            device16Edit.setVisible(false);
            device16Remove.setVisible(false);
            device16ClearAll.setVisible(false);
        } else {
            device16Edit.setVisible(true);
            device16Remove.setVisible(true);
            device16ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device16MenuPopupMenuWillBecomeVisible

    private void device17MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device17MenuPopupMenuWillBecomeVisible
        if (device17.getRowCount() == 0) {
            device17Edit.setVisible(false);
            device17Remove.setVisible(false);
            device17ClearAll.setVisible(false);
        } else {
            device17Edit.setVisible(true);
            device17Remove.setVisible(true);
            device17ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device17MenuPopupMenuWillBecomeVisible

    private void device18MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device18MenuPopupMenuWillBecomeVisible
        if (device18.getRowCount() == 0) {
            device18Edit.setVisible(false);
            device18Remove.setVisible(false);
            device18ClearAll.setVisible(false);
        } else {
            device18Edit.setVisible(true);
            device18Remove.setVisible(true);
            device18ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device18MenuPopupMenuWillBecomeVisible

    private void device19MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device19MenuPopupMenuWillBecomeVisible
        if (device19.getRowCount() == 0) {
            device19Edit.setVisible(false);
            device19Remove.setVisible(false);
            device19ClearAll.setVisible(false);
        } else {
            device19Edit.setVisible(true);
            device19Remove.setVisible(true);
            device19ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device19MenuPopupMenuWillBecomeVisible

    private void device20MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device20MenuPopupMenuWillBecomeVisible
        if (device20.getRowCount() == 0) {
            device20Edit.setVisible(false);
            device20Remove.setVisible(false);
            device20ClearAll.setVisible(false);
        } else {
            device20Edit.setVisible(true);
            device20Remove.setVisible(true);
            device20ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device20MenuPopupMenuWillBecomeVisible

    private void device21MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device21MenuPopupMenuWillBecomeVisible
        if (device21.getRowCount() == 0) {
            device21Edit.setVisible(false);
            device21Remove.setVisible(false);
            device21ClearAll.setVisible(false);
        } else {
            device21Edit.setVisible(true);
            device21Remove.setVisible(true);
            device21ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device21MenuPopupMenuWillBecomeVisible

    private void device22MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device22MenuPopupMenuWillBecomeVisible
        if (device22.getRowCount() == 0) {
            device22Edit.setVisible(false);
            device22Remove.setVisible(false);
            device22ClearAll.setVisible(false);
        } else {
            device22Edit.setVisible(true);
            device22Remove.setVisible(true);
            device22ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device22MenuPopupMenuWillBecomeVisible

    private void device23MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device23MenuPopupMenuWillBecomeVisible
        if (device23.getRowCount() == 0) {
            device23Edit.setVisible(false);
            device23Remove.setVisible(false);
            device23ClearAll.setVisible(false);
        } else {
            device23Edit.setVisible(true);
            device23Remove.setVisible(true);
            device23ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device23MenuPopupMenuWillBecomeVisible

    private void device24MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device24MenuPopupMenuWillBecomeVisible
        if (device24.getRowCount() == 0) {
            device24Edit.setVisible(false);
            device24Remove.setVisible(false);
            device24ClearAll.setVisible(false);
        } else {
            device24Edit.setVisible(true);
            device24Remove.setVisible(true);
            device24ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device24MenuPopupMenuWillBecomeVisible

    private void device25MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device25MenuPopupMenuWillBecomeVisible
        if (device25.getRowCount() == 0) {
            device25Edit.setVisible(false);
            device25Remove.setVisible(false);
            device25ClearAll.setVisible(false);
        } else {
            device25Edit.setVisible(true);
            device25Remove.setVisible(true);
            device25ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device25MenuPopupMenuWillBecomeVisible

    private void device26MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device26MenuPopupMenuWillBecomeVisible
        if (device26.getRowCount() == 0) {
            device26Edit.setVisible(false);
            device26Remove.setVisible(false);
            device26ClearAll.setVisible(false);
        } else {
            device26Edit.setVisible(true);
            device26Remove.setVisible(true);
            device26ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device26MenuPopupMenuWillBecomeVisible

    private void device27MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device27MenuPopupMenuWillBecomeVisible
        if (device27.getRowCount() == 0) {
            device27Edit.setVisible(false);
            device27Remove.setVisible(false);
            device27ClearAll.setVisible(false);
        } else {
            device27Edit.setVisible(true);
            device27Remove.setVisible(true);
            device27ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device27MenuPopupMenuWillBecomeVisible

    private void device28MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device28MenuPopupMenuWillBecomeVisible
        if (device28.getRowCount() == 0) {
            device28Edit.setVisible(false);
            device28Remove.setVisible(false);
            device28ClearAll.setVisible(false);
        } else {
            device28Edit.setVisible(true);
            device28Remove.setVisible(true);
            device28ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device28MenuPopupMenuWillBecomeVisible

    private void device29MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device29MenuPopupMenuWillBecomeVisible
        if (device29.getRowCount() == 0) {
            device29Edit.setVisible(false);
            device29Remove.setVisible(false);
            device29ClearAll.setVisible(false);
        } else {
            device29Edit.setVisible(true);
            device29Remove.setVisible(true);
            device29ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device29MenuPopupMenuWillBecomeVisible

    private void device30MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device30MenuPopupMenuWillBecomeVisible
        if (device30.getRowCount() == 0) {
            device30Edit.setVisible(false);
            device30Remove.setVisible(false);
            device30ClearAll.setVisible(false);
        } else {
            device30Edit.setVisible(true);
            device30Remove.setVisible(true);
            device30ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device30MenuPopupMenuWillBecomeVisible

    private void device31MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device31MenuPopupMenuWillBecomeVisible
        if (device31.getRowCount() == 0) {
            device31Edit.setVisible(false);
            device31Remove.setVisible(false);
            device31ClearAll.setVisible(false);
        } else {
            device31Edit.setVisible(true);
            device31Remove.setVisible(true);
            device31ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device31MenuPopupMenuWillBecomeVisible

    private void device32MenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_device32MenuPopupMenuWillBecomeVisible
        if (device32.getRowCount() == 0) {
            device32Edit.setVisible(false);
            device32Remove.setVisible(false);
            device32ClearAll.setVisible(false);
        } else {
            device32Edit.setVisible(true);
            device32Remove.setVisible(true);
            device32ClearAll.setVisible(true);
        }
    }//GEN-LAST:event_device32MenuPopupMenuWillBecomeVisible

    private void device1ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device1ClearAllMousePressed
        clearTable(device1);
    }//GEN-LAST:event_device1ClearAllMousePressed

    private void device2ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device2ClearAllMousePressed
        clearTable(device2);
    }//GEN-LAST:event_device2ClearAllMousePressed

    private void device3ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device3ClearAllMousePressed
        clearTable(device3);
    }//GEN-LAST:event_device3ClearAllMousePressed

    private void device4ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device4ClearAllMousePressed
        clearTable(device4);
    }//GEN-LAST:event_device4ClearAllMousePressed

    private void device5ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device5ClearAllMousePressed
        clearTable(device5);
    }//GEN-LAST:event_device5ClearAllMousePressed

    private void device6ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device6ClearAllMousePressed
        clearTable(device6);
    }//GEN-LAST:event_device6ClearAllMousePressed

    private void device7ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device7ClearAllMousePressed
        clearTable(device7);
    }//GEN-LAST:event_device7ClearAllMousePressed

    private void device8ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device8ClearAllMousePressed
        clearTable(device8);
    }//GEN-LAST:event_device8ClearAllMousePressed

    private void device9ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device9ClearAllMousePressed
        clearTable(device9);
    }//GEN-LAST:event_device9ClearAllMousePressed

    private void device10ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device10ClearAllMousePressed
        clearTable(device10);
    }//GEN-LAST:event_device10ClearAllMousePressed

    private void device11ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device11ClearAllMousePressed
        clearTable(device11);
    }//GEN-LAST:event_device11ClearAllMousePressed

    private void device12ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device12ClearAllMousePressed
        clearTable(device12);
    }//GEN-LAST:event_device12ClearAllMousePressed

    private void device13ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device13ClearAllMousePressed
        clearTable(device13);
    }//GEN-LAST:event_device13ClearAllMousePressed

    private void device14ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device14ClearAllMousePressed
        clearTable(device14);
    }//GEN-LAST:event_device14ClearAllMousePressed

    private void device15ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device15ClearAllMousePressed
        clearTable(device15);
    }//GEN-LAST:event_device15ClearAllMousePressed

    private void device16ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device16ClearAllMousePressed
        clearTable(device16);
    }//GEN-LAST:event_device16ClearAllMousePressed

    private void device17ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device17ClearAllMousePressed
        clearTable(device17);
    }//GEN-LAST:event_device17ClearAllMousePressed

    private void device18ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device18ClearAllMousePressed
        clearTable(device18);
    }//GEN-LAST:event_device18ClearAllMousePressed

    private void device19ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device19ClearAllMousePressed
        clearTable(device19);
    }//GEN-LAST:event_device19ClearAllMousePressed

    private void device20ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device20ClearAllMousePressed
        clearTable(device20);
    }//GEN-LAST:event_device20ClearAllMousePressed

    private void device21ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device21ClearAllMousePressed
        clearTable(device21);
    }//GEN-LAST:event_device21ClearAllMousePressed

    private void device22ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device22ClearAllMousePressed
        clearTable(device22);
    }//GEN-LAST:event_device22ClearAllMousePressed

    private void device23ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device23ClearAllMousePressed
        clearTable(device23);
    }//GEN-LAST:event_device23ClearAllMousePressed

    private void device24ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device24ClearAllMousePressed
        clearTable(device24);
    }//GEN-LAST:event_device24ClearAllMousePressed

    private void device25ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device25ClearAllMousePressed
        clearTable(device25);
    }//GEN-LAST:event_device25ClearAllMousePressed

    private void device26ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device26ClearAllMousePressed
        clearTable(device26);
    }//GEN-LAST:event_device26ClearAllMousePressed

    private void device27ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device27ClearAllMousePressed
        clearTable(device27);
    }//GEN-LAST:event_device27ClearAllMousePressed

    private void device28ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device28ClearAllMousePressed
        clearTable(device28);
    }//GEN-LAST:event_device28ClearAllMousePressed

    private void device29ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device29ClearAllMousePressed
        clearTable(device29);
    }//GEN-LAST:event_device29ClearAllMousePressed

    private void device30ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device30ClearAllMousePressed
        clearTable(device30);
    }//GEN-LAST:event_device30ClearAllMousePressed

    private void device31ClearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_device31ClearAllActionPerformed

    }//GEN-LAST:event_device31ClearAllActionPerformed

    private void device31ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device31ClearAllMousePressed
        clearTable(device31);
    }//GEN-LAST:event_device31ClearAllMousePressed

    private void device32ClearAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_device32ClearAllMousePressed
        clearTable(device32);
    }//GEN-LAST:event_device32ClearAllMousePressed

    private void displayValueSensorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayValueSensorMousePressed
        if (sensorViewTable.getSelectedRow()>=0){
            ValueSensorChartDialog valueSensorChartDialog = new ValueSensorChartDialog(this, rootPaneCheckingEnabled,
                    sensorViewTable.getValueAt(sensorViewTable.getSelectedRow(), 2).toString());
            valueSensorChartDialog.setVisible(true);
        }
    }//GEN-LAST:event_displayValueSensorMousePressed

    private void addSensorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSensorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addSensorActionPerformed

    private void deleteArduinoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteArduinoMousePressed
        if (ArduinoDeviceViewTable.getSelectedRow() >= 0){
            if (JOptionPane.showConfirmDialog(rootPane, "Delete option?", "SMART", YES_NO_OPTION) == 0) {
                try {
                ArduinoDeviceProvider arduinoDeviceProvider = new ArduinoDeviceProvider();
                arduinoDeviceProvider.deleteByName(ArduinoDeviceViewTable.getValueAt(ArduinoDeviceViewTable.getSelectedRow(),
                        0).toString());
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (URISyntaxException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }//GEN-LAST:event_deleteArduinoMousePressed

    private void deleteSensorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteSensorMousePressed
        if (sensorViewTable.getSelectedRow() >= 0){
            if (JOptionPane.showConfirmDialog(rootPane, "Delete option?", "SMART", YES_NO_OPTION) == 0) {
                try {
                SensorProvider sensorProvider = new SensorProvider();
                sensorProvider.deleteByName(sensorViewTable.getValueAt(sensorViewTable.getSelectedRow(),
                        0).toString());
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (URISyntaxException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }//GEN-LAST:event_deleteSensorMousePressed

    private void deleteCameraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteCameraMousePressed
        if (CamersViewTable.getSelectedRow() >= 0){
            if (JOptionPane.showConfirmDialog(rootPane, "Delete option?", "SMART", YES_NO_OPTION) == 0) {
                try {
                CameraProvider cameraProvider = new CameraProvider();
                cameraProvider.deleteByName(CamersViewTable.getValueAt(CamersViewTable.getSelectedRow(),
                        0).toString());
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (URISyntaxException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }//GEN-LAST:event_deleteCameraMousePressed

    private void deleteDeviceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteDeviceMousePressed
        if (devicesViewTable.getSelectedRow() >= 0){
            if (JOptionPane.showConfirmDialog(rootPane, "Delete option?", "SMART", YES_NO_OPTION) == 0) {
                try {
                DeviceProvider deviceProvider = new DeviceProvider();
                deviceProvider.deleteByName(devicesViewTable.getValueAt(devicesViewTable.getSelectedRow(),
                        0).toString());
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (URISyntaxException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }//GEN-LAST:event_deleteDeviceMousePressed

    private void clearTable(JTable jTable) {
        OptionProvider optionProvider = new OptionProvider();
        try {
            optionProvider.deleteByDevice(jTable.getToolTipText());
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model;
        model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
    }


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ArduinoDeviceViewTable;
    private javax.swing.JTable CamersViewTable;
    private javax.swing.JMenuItem addArduino;
    private javax.swing.JMenuItem addCamera;
    private javax.swing.JMenuItem addDevice;
    private javax.swing.JMenuItem addSensor;
    private javax.swing.JPopupMenu arduinoMenu;
    private javax.swing.JPopupMenu cameraMenu;
    private javax.swing.JMenuItem deleteArduino;
    private javax.swing.JMenuItem deleteCamera;
    private javax.swing.JMenuItem deleteDevice;
    private javax.swing.JMenuItem deleteSensor;
    private javax.swing.JTable device1;
    private javax.swing.JTable device10;
    private javax.swing.JMenuItem device10Add;
    private javax.swing.JMenuItem device10ClearAll;
    private javax.swing.JMenuItem device10Edit;
    private javax.swing.JPopupMenu device10Menu;
    private javax.swing.JPanel device10Panel;
    private javax.swing.JMenuItem device10Remove;
    private javax.swing.JTable device11;
    private javax.swing.JMenuItem device11Add;
    private javax.swing.JMenuItem device11ClearAll;
    private javax.swing.JMenuItem device11Edit;
    private javax.swing.JPopupMenu device11Menu;
    private javax.swing.JMenuItem device11Remove;
    private javax.swing.JTable device12;
    private javax.swing.JMenuItem device12Add;
    private javax.swing.JMenuItem device12ClearAll;
    private javax.swing.JMenuItem device12Edit;
    private javax.swing.JPopupMenu device12Menu;
    private javax.swing.JMenuItem device12Remove;
    private javax.swing.JTable device13;
    private javax.swing.JMenuItem device13Add;
    private javax.swing.JMenuItem device13ClearAll;
    private javax.swing.JMenuItem device13Edit;
    private javax.swing.JPopupMenu device13Menu;
    private javax.swing.JMenuItem device13Remove;
    private javax.swing.JTable device14;
    private javax.swing.JMenuItem device14Add;
    private javax.swing.JMenuItem device14ClearAll;
    private javax.swing.JMenuItem device14Edit;
    private javax.swing.JPopupMenu device14Menu;
    private javax.swing.JMenuItem device14Remove;
    private javax.swing.JTable device15;
    private javax.swing.JMenuItem device15Add;
    private javax.swing.JMenuItem device15ClearAll;
    private javax.swing.JMenuItem device15Edit;
    private javax.swing.JPopupMenu device15Menu;
    private javax.swing.JMenuItem device15Remove;
    private javax.swing.JTable device16;
    private javax.swing.JMenuItem device16Add;
    private javax.swing.JMenuItem device16ClearAll;
    private javax.swing.JMenuItem device16Edit;
    private javax.swing.JPopupMenu device16Menu;
    private javax.swing.JMenuItem device16Remove;
    private javax.swing.JTable device17;
    private javax.swing.JMenuItem device17Add;
    private javax.swing.JMenuItem device17ClearAll;
    private javax.swing.JMenuItem device17Edit;
    private javax.swing.JPopupMenu device17Menu;
    private javax.swing.JMenuItem device17Remove;
    private javax.swing.JTable device18;
    private javax.swing.JMenuItem device18Add;
    private javax.swing.JMenuItem device18ClearAll;
    private javax.swing.JMenuItem device18Edit;
    private javax.swing.JPopupMenu device18Menu;
    private javax.swing.JMenuItem device18Remove;
    private javax.swing.JTable device19;
    private javax.swing.JMenuItem device19Add;
    private javax.swing.JMenuItem device19ClearAll;
    private javax.swing.JMenuItem device19Edit;
    private javax.swing.JPopupMenu device19Menu;
    private javax.swing.JMenuItem device19Remove;
    private javax.swing.JMenuItem device1Add;
    private javax.swing.JMenuItem device1ClearAll;
    private javax.swing.JMenuItem device1Edit;
    private javax.swing.JPopupMenu device1Menu;
    private javax.swing.JPanel device1Panel;
    private javax.swing.JMenuItem device1Remove;
    private javax.swing.JTable device2;
    private javax.swing.JTable device20;
    private javax.swing.JMenuItem device20Add;
    private javax.swing.JMenuItem device20ClearAll;
    private javax.swing.JMenuItem device20Edit;
    private javax.swing.JPopupMenu device20Menu;
    private javax.swing.JMenuItem device20Remove;
    private javax.swing.JTable device21;
    private javax.swing.JMenuItem device21Add;
    private javax.swing.JMenuItem device21ClearAll;
    private javax.swing.JMenuItem device21Edit;
    private javax.swing.JPopupMenu device21Menu;
    private javax.swing.JMenuItem device21Remove;
    private javax.swing.JTable device22;
    private javax.swing.JMenuItem device22Add;
    private javax.swing.JMenuItem device22ClearAll;
    private javax.swing.JMenuItem device22Edit;
    private javax.swing.JPopupMenu device22Menu;
    private javax.swing.JMenuItem device22Remove;
    private javax.swing.JTable device23;
    private javax.swing.JMenuItem device23Add;
    private javax.swing.JMenuItem device23ClearAll;
    private javax.swing.JMenuItem device23Edit;
    private javax.swing.JPopupMenu device23Menu;
    private javax.swing.JMenuItem device23Remove;
    private javax.swing.JTable device24;
    private javax.swing.JMenuItem device24Add;
    private javax.swing.JMenuItem device24ClearAll;
    private javax.swing.JMenuItem device24Edit;
    private javax.swing.JPopupMenu device24Menu;
    private javax.swing.JMenuItem device24Remove;
    private javax.swing.JTable device25;
    private javax.swing.JMenuItem device25Add;
    private javax.swing.JMenuItem device25ClearAll;
    private javax.swing.JMenuItem device25Edit;
    private javax.swing.JPopupMenu device25Menu;
    private javax.swing.JMenuItem device25Remove;
    private javax.swing.JTable device26;
    private javax.swing.JMenuItem device26Add;
    private javax.swing.JMenuItem device26ClearAll;
    private javax.swing.JMenuItem device26Edit;
    private javax.swing.JPopupMenu device26Menu;
    private javax.swing.JMenuItem device26Remove;
    private javax.swing.JTable device27;
    private javax.swing.JMenuItem device27Add;
    private javax.swing.JMenuItem device27ClearAll;
    private javax.swing.JMenuItem device27Edit;
    private javax.swing.JPopupMenu device27Menu;
    private javax.swing.JMenuItem device27Remove;
    private javax.swing.JTable device28;
    private javax.swing.JMenuItem device28Add;
    private javax.swing.JMenuItem device28ClearAll;
    private javax.swing.JMenuItem device28Edit;
    private javax.swing.JPopupMenu device28Menu;
    private javax.swing.JMenuItem device28Remove;
    private javax.swing.JTable device29;
    private javax.swing.JMenuItem device29Add;
    private javax.swing.JMenuItem device29ClearAll;
    private javax.swing.JMenuItem device29Edit;
    private javax.swing.JPopupMenu device29Menu;
    private javax.swing.JMenuItem device29Remove;
    private javax.swing.JMenuItem device2Add;
    private javax.swing.JMenuItem device2ClearAll;
    private javax.swing.JMenuItem device2Edit;
    private javax.swing.JPopupMenu device2Menu;
    private javax.swing.JPanel device2Panel;
    private javax.swing.JMenuItem device2Remove;
    private javax.swing.JTable device3;
    private javax.swing.JTable device30;
    private javax.swing.JMenuItem device30Add;
    private javax.swing.JMenuItem device30ClearAll;
    private javax.swing.JMenuItem device30Edit;
    private javax.swing.JPopupMenu device30Menu;
    private javax.swing.JMenuItem device30Remove;
    private javax.swing.JTable device31;
    private javax.swing.JMenuItem device31Add;
    private javax.swing.JMenuItem device31ClearAll;
    private javax.swing.JMenuItem device31Edit;
    private javax.swing.JPopupMenu device31Menu;
    private javax.swing.JMenuItem device31Remove;
    private javax.swing.JTable device32;
    private javax.swing.JMenuItem device32Add;
    private javax.swing.JMenuItem device32ClearAll;
    private javax.swing.JMenuItem device32Edit;
    private javax.swing.JPopupMenu device32Menu;
    private javax.swing.JMenuItem device32Remove;
    private javax.swing.JMenuItem device3Add;
    private javax.swing.JMenuItem device3ClearAll;
    private javax.swing.JMenuItem device3Edit;
    private javax.swing.JPopupMenu device3Menu;
    private javax.swing.JPanel device3Panel;
    private javax.swing.JMenuItem device3Remove;
    private javax.swing.JTable device4;
    private javax.swing.JMenuItem device4Add;
    private javax.swing.JMenuItem device4ClearAll;
    private javax.swing.JMenuItem device4Edit;
    private javax.swing.JPopupMenu device4Menu;
    private javax.swing.JPanel device4Panel;
    private javax.swing.JMenuItem device4Remove;
    private javax.swing.JTable device5;
    private javax.swing.JMenuItem device5Add;
    private javax.swing.JMenuItem device5ClearAll;
    private javax.swing.JMenuItem device5Edit;
    private javax.swing.JPopupMenu device5Menu;
    private javax.swing.JPanel device5Panel;
    private javax.swing.JMenuItem device5Remove;
    private javax.swing.JTable device6;
    private javax.swing.JMenuItem device6Add;
    private javax.swing.JMenuItem device6ClearAll;
    private javax.swing.JMenuItem device6Edit;
    private javax.swing.JPopupMenu device6Menu;
    private javax.swing.JPanel device6Panel;
    private javax.swing.JMenuItem device6Remove;
    private javax.swing.JTable device7;
    private javax.swing.JMenuItem device7Add;
    private javax.swing.JMenuItem device7ClearAll;
    private javax.swing.JMenuItem device7Edit;
    private javax.swing.JPopupMenu device7Menu;
    private javax.swing.JPanel device7Panel;
    private javax.swing.JMenuItem device7Remove;
    private javax.swing.JTable device8;
    private javax.swing.JMenuItem device8Add;
    private javax.swing.JMenuItem device8ClearAll;
    private javax.swing.JMenuItem device8Edit;
    private javax.swing.JPopupMenu device8Menu;
    private javax.swing.JPanel device8Panel;
    private javax.swing.JMenuItem device8Remove;
    private javax.swing.JTable device9;
    private javax.swing.JMenuItem device9Add;
    private javax.swing.JMenuItem device9ClearAll;
    private javax.swing.JMenuItem device9Edit;
    private javax.swing.JPopupMenu device9Menu;
    private javax.swing.JPanel device9Panel;
    private javax.swing.JMenuItem device9Remove;
    private javax.swing.JPopupMenu deviceMenu;
    private javax.swing.JTable devicesViewTable;
    private javax.swing.JMenuItem displayValueSensor;
    private javax.swing.JMenuItem editArduino;
    private javax.swing.JMenuItem editCamera;
    private javax.swing.JMenuItem editDevice;
    private javax.swing.JMenuItem editSensor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JScrollPane jScrollPane33;
    private javax.swing.JScrollPane jScrollPane34;
    private javax.swing.JScrollPane jScrollPane35;
    private javax.swing.JScrollPane jScrollPane36;
    private javax.swing.JScrollPane jScrollPane37;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane10;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTabbedPane jTabbedPane8;
    private javax.swing.JTabbedPane jTabbedPane9;
    private javax.swing.JTable optionsViewTable;
    private javax.swing.JPopupMenu sensorMenu;
    private javax.swing.JTable sensorViewTable;
    // End of variables declaration//GEN-END:variables
}
