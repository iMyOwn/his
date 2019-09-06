package view;

import bridge.BridgeMaster;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScene implements Initializable {
    @FXML
    WebView webView;

    private WebEngine webEngine;

    // 存一个stage对象的引用，以便于修改窗口尺寸等属性
    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        webEngine = webView.getEngine();

        // 载入前端页面
        webEngine.load(getClass().getResource("../html/index.html").toExternalForm());

        // 在webview中禁用右键
        webView.setContextMenuEnabled(false);

        // 使得webview中的表单能获取到焦点
        webView.requestFocus();

        // 把WebEngine对象注册进BridgeMaster工厂
        BridgeMaster.setWebEngine(webEngine);

        // 通过类名指定需要挂载到JS运行时里的对象
        BridgeMaster.addBridge("Lifecycle");
        BridgeMaster.addBridge("Request");
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * 改变窗口的大小
     *
     * @param newWidth  新的宽度
     * @param newHeight 新的高度
     */
    public void changeSize(double newWidth, double newHeight) {
        stage.close();
        stage.setWidth(newWidth);
        stage.setHeight(newHeight);
        webView.setPrefWidth(newWidth);
        webView.setPrefHeight(newHeight);
        stage.centerOnScreen();
        stage.show();
    }
}