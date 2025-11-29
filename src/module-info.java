module KinzCollector {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	requires javafx.base;
	requires org.controlsfx.controls;
	
	opens application;
	opens controllers;
	opens views;
}