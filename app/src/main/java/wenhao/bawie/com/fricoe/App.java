package wenhao.bawie.com.fricoe;

import android.app.Application;
import android.os.Environment;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

import java.io.File;

/**
 * Created by HP on 2018/10/30.
 */

public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        //Fresco.initialize(this);
        // 高级初始化：
        Fresco.initialize(this, ImagePipelineConfig.newBuilder(App.this)
                .setMainDiskCacheConfig(
                        DiskCacheConfig.newBuilder(this)
                                .setBaseDirectoryPath(new File(Environment.getExternalStorageDirectory().getAbsolutePath())) // 注意Android运行时权限。
                                .build()
                )
                .build()
        );
    }
}
