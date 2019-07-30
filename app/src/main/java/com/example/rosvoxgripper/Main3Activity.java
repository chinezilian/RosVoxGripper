package com.example.rosvoxgripper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.ros.android.RosActivity;
import org.ros.node.NodeConfiguration;
import org.ros.node.NodeMainExecutor;

public class Main3Activity extends RosActivity {
    public static EditText edNode,edTopic;
    private Listener listener;

    public Main3Activity() {
        super("RobotOperation", "RobotOperation");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        edNode=(EditText)findViewById(R.id.editTextNode);
        edTopic=(EditText)findViewById(R.id.editTextTopic);



    }

    public void startThirdActivity(View view) {

        Intent thirdActivity = new Intent(this, MainActivity.class);
        startActivity(thirdActivity);
    }

    @Override
    protected void init(NodeMainExecutor nodeMainExecutor) {
        listener = new Listener();
        NodeConfiguration nodeConfiguration = NodeConfiguration.newPublic(getRosHostname());
        nodeConfiguration.setMasterUri(getMasterUri());
        nodeMainExecutor.execute(listener, nodeConfiguration);
    }
}

