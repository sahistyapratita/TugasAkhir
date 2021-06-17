package akhirr;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Sahistya Pratita
 * @version 4.3
 * @since 1.0
 */
public class
TA extends Application {

    /**
     *
     * @param args sebagai parameter class main
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     *
     * @param primaryStage untuk start aplikasi
     */
    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("PERHITUNGAN GAJI");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Button btn = new Button("HITUNG");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 11);

        Scene scene = new Scene(grid, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

        Text title = new Text("GAJI PERUSAHAAN");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
        grid.add(title, 0, 0, 1, 1);

        Label THN = new Label("Tahun Masuk");
        grid.add(THN, 0, 1);

        TextField tahun = new TextField();
        tahun.setPromptText("Masukan Tahun");
        grid.add(tahun, 1, 1);

        Label bulan = new Label("Bulan");
        grid.add(bulan, 0, 2);

        ChoiceBox<String> bl = new ChoiceBox<>(FXCollections.observableArrayList("Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"));
        grid.add(bl, 1, 2);

        Label Jam = new Label("Jam Lembur");
        grid.add(Jam, 0, 3);

        TextField jam = new TextField();
        jam.setPromptText("Masukkan Jam");
        grid.add(jam, 1, 3);
        

        Label Jab = new Label("Jabatan");
        grid.add(Jab, 0, 4);
        ChoiceBox<String> jb = new ChoiceBox<>(FXCollections.observableArrayList("Staff","Manager","Direktur"));
        grid.add(jb, 1, 4);
        jb.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
                    Text teks =new Text("PERLU DIPERHATIKAN!!");
                    teks.setFill(Color.RED);
                    grid.add(teks,0,5);
                    Text teks1 =new Text("Harap Pilih Gaji Pokok \nSesuai Jabatan!!");
                    teks1.setFill(Color.RED);
                    grid.add(teks1,0,6);
                    Text teks2 =new Text("Staf\t\t : Rp. 7.000.000 \nManager\t : Rp. 10.000.000\nDirektur\t : Rp. 17.500.000");
                    teks2.setFill(Color.RED);
                    grid.add(teks2,1,6);
                });

        Label Gj = new Label("Gaji Pokok");
        grid.add(Gj, 0, 7);
        ChoiceBox<String> gaji = new ChoiceBox<>(FXCollections.observableArrayList("7000000","10000000","17500000"));
        grid.add(gaji, 1, 7);


        btn.setOnAction(new EventHandler<ActionEvent>() {
            /**
             *
             * @param event parameter untuk action dari button
             */
            @Override
            public void handle(ActionEvent event) {

                String TAHUN = tahun.getText();
                String BULAN = bl.getValue();
                String JAM = jam.getText();
                String JABATAN = jb.getValue();
                int GAJI = Integer.parseInt(gaji.getValue());
                int BONUS = Integer.parseInt(jam.getText());

                if (TAHUN.matches("[0-9]+")&& TAHUN.length()==4) {
                    systemInformation("Information", "Input Success", "Data Telah Ditambahkan");
                    GridPane gridPane = new GridPane();
                    gridPane.setAlignment(Pos.CENTER);
                    gridPane.setVgap(10);

                    Text title1 = new Text("GAJI");
                    title1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
                    gridPane.add(title1, 0, 0, 2, 1);


                    Label tahun1 = new Label("Tahun Masuk");
                    tahun1.setFont(Font.font("Times New Roman", FontWeight.NORMAL,14));
                    gridPane.add(tahun1,0,1);

                    Label bulan1 = new Label("Bulan");
                    bulan1.setFont(Font.font("Times New Roman", FontWeight.NORMAL,14));
                    gridPane.add(bulan1,0,2);

                    Label jam1 = new Label("Jam Lembur");
                    jam1.setFont(Font.font("Times New Roman", FontWeight.NORMAL,14));
                    gridPane.add(jam1,0,3);

                    Label jabatan1 = new Label("Jabatan");
                    jabatan1.setFont(Font.font("Times New Roman", FontWeight.NORMAL,14));
                    gridPane.add(jabatan1,0,4);

                    Label gaji1 = new Label("Gaji");
                    gaji1.setFont(Font.font("Times New Roman", FontWeight.NORMAL,14));
                    gridPane.add(gaji1,0,5);

                    Label bonus1 = new Label("Bonus");
                    bonus1.setFont(Font.font("Times New Roman", FontWeight.NORMAL,14));
                    gridPane.add(bonus1,0,6);

                    Label tunjangan1 = new Label("Tunjangan");
                    tunjangan1.setFont(Font.font("Times New Roman", FontWeight.NORMAL,14));
                    gridPane.add(tunjangan1,0,7);
                    if (GAJI == 17500000){
                        int Tunjangan1,tunjangan2;
                        Tunjangan1 = GAJI*20/100;
                        tunjangan2 = Tunjangan1;
                        Text tunjangan3 = new Text(" :   "+tunjangan2);
                        gridPane.add(tunjangan3,1,7);

                        int bonus4;
                        bonus4 = BONUS * 100000;
                        Text bonus5 = new Text(" :   "+bonus4);
                        gridPane.add(bonus5,1,6);

                        Label total = new Label("Total Gaji");
                        gridPane.add(total,0,8);
                        int hitung;
                        hitung = GAJI + tunjangan2 + bonus4;
                        Text total1 = new Text(" :   "+hitung);
                        gridPane.add(total1,1,8 );

                    }else if (GAJI == 10000000){
                        int tunjangan4,tunjangan5;
                        tunjangan4 = GAJI*15/100;
                        tunjangan5 = tunjangan4;
                        Text tunjangan6 = new Text(" :   "+tunjangan5);
                        gridPane.add(tunjangan6,1,7);

                        int bonus6;
                        bonus6 = BONUS * 100000;
                        Text bonus7 = new Text(" :   "+bonus6);
                        gridPane.add(bonus7,1,6);

                        Label total2 = new Label("Total Gaji");
                        gridPane.add(total2,0,8);
                        int hitung1;
                        hitung1 = GAJI + tunjangan5 + bonus6;
                        Text total3 = new Text(" :   "+hitung1);
                        gridPane.add(total3,1,8);

                    }else if (GAJI == 7000000){
                        int tunjangan7,tunjangan8;
                        tunjangan7 = GAJI*10/100;
                        tunjangan8 = tunjangan7;
                        Text tunjangan9 = new Text(" :   "+tunjangan8);
                        gridPane.add(tunjangan9,1,7);

                        int bonus8;
                        bonus8 = BONUS * 100000;
                        Text bonus9 = new Text(" :   "+bonus8);
                        gridPane.add(bonus9,1,6);

                        Label total4 = new Label("Total Gaji");
                        gridPane.add(total4,0,8);
                        int hitung2;
                        hitung2 = GAJI + tunjangan8 + bonus8;
                        Text total5 = new Text(" :   "+hitung2);
                        gridPane.add(total5,1,8);

                    }

                    Text tahun2 =new Text(" :   "+TAHUN);gridPane.add(tahun2,1,1);
                    Text bulan2 =new Text(" :   "+BULAN);gridPane.add(bulan2,1,2);
                    Text jam2 =new Text(" :   "+JAM);gridPane.add(jam2,1,3);
                    Text jabatan2 =new Text(" :   "+JABATAN);gridPane.add(jabatan2,1,4);
                    Text gaji2 =new Text(" :   "+GAJI);gridPane.add(gaji2,1,5);

                    Button Back= new Button("Back");gridPane.add(Back,1,10);

                    Back.setOnAction(new EventHandler<ActionEvent>() {
                        /**
                         *
                         * @param event parameter button back untuk kembali ke stage awal
                         */
                        @Override
                        public void handle(ActionEvent event) {
                            start(primaryStage);
                        }
                    });

                    Scene scene1 = new Scene(gridPane,500,500);
                    primaryStage.setScene(scene1);
                    primaryStage.show();

                } else {
                    systemWarning("Warning", "Tahun Error", "Harus 4 Digit\nTolong Input Data kembali");
                }
            }
        });
        primaryStage.show();
    }

    /**
     *
     * @param title sebagai judul dari informasi data berhasil di input
     * @param header awalan kalimat informasi
     * @param isi isi informasi jika data sudah di proses
     */

    public void systemInformation(String title, String header, String isi) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(isi);
        alert.showAndWait();
    }

    /**
     *
     * @param title sebagai judul warning kesalahan  inputan
     * @param header awalan kalimat warning
     * @param isi isi warning jika ada kesalahan
     */
    public void systemWarning(String title, String header, String isi) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(isi);
        alert.showAndWait();
    }
}