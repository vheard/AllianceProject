
//@author Von Heard
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class roomservices extends javax.swing.JFrame{
        
    private static DefaultTableModel table;
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    TableColumn tc;
    JPopupMenu qpopup;
    
    public roomservices() throws ClassNotFoundException {  
        initComponents();
        conn = Connect.dbConnector();
        modifications(); 
    }
    
    private void modifications() throws ClassNotFoundException{
        selectedItemsTable.setToolTipText(null);
        roomservices.table = (DefaultTableModel) selectedItemsTable.getModel();
        tc = selectedItemsTable.getColumnModel().getColumn(1);
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment((int) JLabel.LEFT);
        tc.setCellRenderer(dtcr);
    }
    //quantity method
    private void getQuantity(Object[]o, DefaultTableModel dtm, int i){
        Object [] q = {"1","2","3","4","5","6","7","8","9","10"};
                    String quantity = (String) JOptionPane.showInputDialog(this, "Quantity: ", "", JOptionPane.PLAIN_MESSAGE, null, q, q[0]);
                    if(quantity!=null){
                        for(int j=0;j<q.length;j++){
                            if(quantity.equalsIgnoreCase((String) q[j])){
                                table.addRow(o);
                                table.setValueAt(q[j], table.getRowCount()-1, 1);
                            }
                        }   
                    }
    }
    //adds items from list to table
    private void populateTable(JList<String> items){ 
        Object[] o = new Object[items.getComponentCount()];     //sets array o size = num of items in jlist
        int i=0;
        for(String value : items.getSelectedValuesList()){      
            o[i] = (Object) value;      //iterates through each selected value and add it to the array
            
            switch(value){
                case "Rags":
                case "Towel":
                case "Sheets":
                case "Pillow Cases":
                case "Comforter":
                case "Pillow":
                case "Tissue":
                case "Trash Bags":
                case "Soap":
                    getQuantity(o, table, i);
                    break;
                case "Other":
                    String in = (String) JOptionPane.showInputDialog(this, "Other: ", "", JOptionPane.PLAIN_MESSAGE);
                    if(in!=null){
                        value = in;
                        o[i] = value;
                        //getQuantity(o, table, i);
                        table.addRow(o);
                        table.setValueAt("", table.getRowCount()-1, 1);
                        }
                    break;
                case "Burger":
                    Object [] bgtype = {"Plain", "Plain w/ cheese", "Plain w/ cheese & ketchup", "Plain w/ cheese, ketchup, & mayo", "Plain w/ cheese, lettuce, tomato, ketchup, & mayo"};
                    String typeSelbg = (String) JOptionPane.showInputDialog(this, "Type: ", "", JOptionPane.QUESTION_MESSAGE, null, bgtype, bgtype[0]);
                    if(typeSelbg!=null){
                        for (Object type1 : bgtype) {
                            if (typeSelbg.equalsIgnoreCase((String) type1)) {
                                value = value + " (" + typeSelbg +")";
                            }
                        }
                            o[i] = value;
                            getQuantity(o, table, i);
                    }
                    break;
                case "Wings": 
                    Object [] wtype = {"Lemon Peper", "Barbecue", "Plain", "Hot", "Mild"};
                    String typeSel = (String) JOptionPane.showInputDialog(this, "Type: ", "", JOptionPane.QUESTION_MESSAGE, null, wtype, wtype[4]);
                    if(typeSel!=null){
                        for (Object type1 : wtype) {
                            if (typeSel.equalsIgnoreCase((String) type1)) {
                                value = value + " (" + typeSel +")";
                            }
                        }
                            o[i] = value;
                            getQuantity(o, table, i);
                    }
                    break;
                case "Pizza":
                    Object [] ptype = {"Pepperoni", "Cheese", "Supreme"};
                    String typeSelp = (String) JOptionPane.showInputDialog(this, "Type: ", "", JOptionPane.QUESTION_MESSAGE, null, ptype, ptype[0]);
                    if(typeSelp!=null){
                        for (Object type1 : ptype) {
                            if (typeSelp.equalsIgnoreCase((String) type1)) {
                                value = value + " (" + typeSelp +")";
                            }
                        }
                            o[i] = value;
                            getQuantity(o, table, i);
                    }
                    break;
                case "Sandwich":
                    Object [] stype = {"Ham w/ cheese", "Ham w/ cheese & mayo", "Ham - Plain", "Turkey w/ cheese", "Turkey w/ cheese & mayo", "Turkey - Plain", "PB&J"};
                    String typeSels = (String) JOptionPane.showInputDialog(this, "Type: ", "", JOptionPane.QUESTION_MESSAGE, null, stype, stype[0]);
                    if(typeSels!=null){
                        for (Object type1 : stype) {
                            if (typeSels.equalsIgnoreCase((String) type1)) {
                                value = value + " (" + typeSels +")";
                            }
                        }
                            o[i] = value;
                            getQuantity(o, table, i);
                    }
                    break;
                case "Fries":
                    Object [] frtype = {"Small", "Large"};
                    String typeSelfr = (String) JOptionPane.showInputDialog(this, "Type: ", "", JOptionPane.QUESTION_MESSAGE, null, frtype, frtype[0]);
                    if(typeSelfr!=null){
                        for (Object type1 : frtype) {
                            if (typeSelfr.equalsIgnoreCase((String) type1)) {
                                value = value + " (" + typeSelfr +")";
                            }
                        }
                            o[i] = value;
                            getQuantity(o, table, i);
                    }
                    break;
                case "Chips":
                    Object [] ctype = {"Doritos - Nacho Cheese", "Doritos - Cool Ranch", "Lays - Plain", "Lays - Barbecue", "Lays - Sour Cream and Onion"};
                    String typeSelc = (String) JOptionPane.showInputDialog(this, "Type: ", "", JOptionPane.QUESTION_MESSAGE, null, ctype, ctype[0]);
                    if(typeSelc!=null){
                        for (Object type1 : ctype) {
                            if (typeSelc.equalsIgnoreCase((String) type1)) {
                                value = value + " (" + typeSelc +")";
                            }
                        }
                            o[i] = value;
                            getQuantity(o, table, i);
                    }
                    break;
                case "Fruit":
                    Object [] ftype = {"Apple", "Orange", "Banana", "Pineapples - 1 cup", "Peaches - 1 cup"};
                    String typeSelf = (String) JOptionPane.showInputDialog(this, "Type: ", "", JOptionPane.QUESTION_MESSAGE, null, ftype, ftype[0]);
                    if(typeSelf!=null){
                        for (Object type1 : ftype) {
                            if (typeSelf.equalsIgnoreCase((String) type1)) {
                                value = value + " (" + typeSelf +")";
                            }
                        }
                            o[i] = value;
                            getQuantity(o, table, i);
                    }
                    break;
                case "Cookies":
                    Object [] cotype = {"Chocolate Chip", "Peanut Butter", "Sugar", "Oatmeal"};
                    String typeSelco = (String) JOptionPane.showInputDialog(this, "Type: ", "", JOptionPane.QUESTION_MESSAGE, null, cotype, cotype[0]);
                    if(typeSelco!=null){
                        for (Object type1 : cotype) {
                            if (typeSelco.equalsIgnoreCase((String) type1)) {
                                value = value + " (" + typeSelco +")";
                            }
                        }
                            o[i] = value;
                            getQuantity(o, table, i);
                    }
                    break;
                case "Beverage":
                    Object [] btype = {"Coke", "Diet Coke", "Sprite", "Fanta - Orange", "Moutain Dew", "Water"};
                    String typeSelb = (String) JOptionPane.showInputDialog(this, "Type: ", "", JOptionPane.QUESTION_MESSAGE, null, btype, btype[0]);
                    if(typeSelb!=null){
                        for (Object type1 : btype) {
                            if (typeSelb.equalsIgnoreCase((String) type1)) {
                                value = value + " (" + typeSelb +")";
                            }
                        }
                            o[i] = value;
                            getQuantity(o, table, i);
                    }
                    break;
            }
            i++;
        }
    }
    //removes row from table
    private void removeItem(DefaultTableModel t){
        for(Object o: selectedItemsTable.getSelectedRows()){
        t.removeRow(selectedItemsTable.getSelectedRow());
        }
    }
    //removes all rows from table after submission
    private void removeAll(DefaultTableModel t){
        int rcount = t.getRowCount();
        int[] row = new int[rcount];
        for(int i=0; i<rcount; i++){
            t.removeRow(row[i]);    //removes each element in table
        }
    }
    //gets table data and inserts into sqlite database
    private void getTableData(DefaultTableModel tm){
        
        int rows = tm.getRowCount();
        
        for(int r=0;r<rows;r++){
            conn = Connect.dbConnector();
                String roomnum = RoomNum.getText();
                String item = tm.getValueAt(r, 0).toString();   //every row in col 0
                String quantity = tm.getValueAt(r, 1).toString();   //every row in col 1
                try{
                    String query = "insert into Request (RoomNum, Item, Quantity) values (?, ?, ?)";
                    ps = conn.prepareStatement(query);
                    ps.setString(1, roomnum);
                    ps.setString(2, item);
                    ps.setString(3, quantity);
                    ps.execute();
                    conn.close();
                    JOptionPane.showMessageDialog(null, "Submitted!");
                }
                
                catch(SQLException e){
                     JOptionPane.showMessageDialog(null, e);
                }
        }
        
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        restaurantButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        selectedItemsTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        needsList = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        FoodList = new javax.swing.JList<>();
        RemoveButton = new javax.swing.JButton();
        SelectNeed = new javax.swing.JButton();
        SelectFood = new javax.swing.JButton();
        SubmitButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        RoomNum = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Room Services");
        setBackground(new java.awt.Color(255, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("Room Services"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        jLabel1.setText("Services provided");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Food/Beverages");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Needs");

        restaurantButton.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        restaurantButton.setText("Restaurants nearby");
        restaurantButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        restaurantButton.setFocusable(false);
        restaurantButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        restaurantButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        restaurantButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restaurantButtonActionPerformed(evt);
            }
        });

        selectedItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        selectedItemsTable.setCellSelectionEnabled(true);
        selectedItemsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        selectedItemsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectedItemsTableMouseClicked(evt);
            }
        });
        selectedItemsTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                selectedItemsTableKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(selectedItemsTable);
        selectedItemsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel4.setText("Selected Items");

        needsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Tissue", "Rags", "Towel", "Soap", "Trash Bags", "Sheets", "Pillow Cases", "Comforter", "Pillow", "Other" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        needsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        needsList.setDragEnabled(true);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, selectedItemsTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElements}"), needsList, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        needsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                needsListMouseDoubleClicked(evt);
            }
        });
        jScrollPane3.setViewportView(needsList);

        FoodList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Burger", "Wings", "Pizza", "Sandwich", "Fries", "Chips", "Fruit", "Cookies", "Beverage" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        FoodList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        FoodList.setToolTipText("");
        FoodList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                foodListDoubleClicked(evt);
            }
        });
        jScrollPane4.setViewportView(FoodList);

        RemoveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RemoveButton.setLabel("Remove ");
        RemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveButtonActionPerformed(evt);
            }
        });

        SelectNeed.setText("Select");
        SelectNeed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SelectNeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectNeedActionPerformed(evt);
            }
        });

        SelectFood.setText("Select");
        SelectFood.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SelectFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectFoodActionPerformed(evt);
            }
        });

        SubmitButton.setText("SUBMIT ");
        SubmitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Log Out");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Enter Room  #:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addGap(15, 15, 15)
                                .addComponent(RoomNum, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(104, 104, 104))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SelectNeed, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(SelectFood, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(RemoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(234, 234, 234))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(98, 98, 98)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(213, 213, 213))))
            .addGroup(layout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(restaurantButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {RemoveButton, SelectFood, SelectNeed, SubmitButton, jButton1, restaurantButton});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane3, jScrollPane4});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelectFood, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SelectNeed, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(restaurantButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(RoomNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RemoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleParent(jScrollPane2);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void restaurantButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restaurantButtonActionPerformed
        this.setVisible(false);//.dispose();
        new Restaurants().setVisible(true);
    }//GEN-LAST:event_restaurantButtonActionPerformed

    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveButtonActionPerformed
        removeItem(table);
    }//GEN-LAST:event_RemoveButtonActionPerformed
    
    private void SelectNeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectNeedActionPerformed
        populateTable(needsList);
    }//GEN-LAST:event_SelectNeedActionPerformed

    private void SelectFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectFoodActionPerformed
        populateTable(FoodList);
    }//GEN-LAST:event_SelectFoodActionPerformed

    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
        getTableData(table);
        removeAll(table);
    }//GEN-LAST:event_SubmitButtonActionPerformed

    private void selectedItemsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectedItemsTableMouseClicked
            DefaultTableModel model = new DefaultTableModel() {
            boolean[] Edit = new boolean[]{
                    false, true
            };
            @Override   
            public boolean isCellEditable(int ri, int ci) {
                return Edit[ci];
            }
            };
    }//GEN-LAST:event_selectedItemsTableMouseClicked

    private void selectedItemsTableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_selectedItemsTableKeyTyped
        int code = evt.getKeyCode();
        for(Object o:selectedItemsTable.getSelectedRows()){
            if(code==KeyEvent.VK_DELETE){
                removeItem(table);
            }
        }
    }//GEN-LAST:event_selectedItemsTableKeyTyped

    private void needsListMouseDoubleClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_needsListMouseDoubleClicked
        if(evt.getClickCount() == 2){
            populateTable(needsList);
        }
    }//GEN-LAST:event_needsListMouseDoubleClicked

    private void foodListDoubleClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_foodListDoubleClicked
        if(evt.getClickCount() == 2){
            populateTable(FoodList);
        }
    }//GEN-LAST:event_foodListDoubleClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.hide();
        RoomSvc alliance = new RoomSvc();
        alliance.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(roomservices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new roomservices().setVisible(true);
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(roomservices.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> FoodList;
    private javax.swing.JButton RemoveButton;
    private javax.swing.JTextField RoomNum;
    private javax.swing.JButton SelectFood;
    private javax.swing.JButton SelectNeed;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<String> needsList;
    private javax.swing.JButton restaurantButton;
    private javax.swing.JTable selectedItemsTable;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    
}
