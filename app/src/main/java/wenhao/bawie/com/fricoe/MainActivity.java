package wenhao.bawie.com.fricoe;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class MainActivity extends AppCompatActivity {

    private SimpleDraweeView mSimpleDraweeView;
    private String imageUrl="https://img.huxiucdn.com/article/cover/201810/29/153108448766.jpg";
    private String URL_="https://img3.duitang.com/uploads/item/201605/14/20160514165650_RHr3n.gif";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSimpleDraweeView= (SimpleDraweeView)findViewById(R.id.simple_view);
        //普通图片加载
        //mSimpleDraweeView.setImageURI("https://img.huxiucdn.com/article/cover/201810/29/153108448766.jpg");
        //高斯模糊
        //showUrlBlur(mSimpleDraweeView,imageUrl,100,10);
        //gif图片
        Uri uri = Uri.parse("res://ming.abner.com.fresco1030/" + R.mipmap.ic_launcher);
        mSimpleDraweeView.setImageURI(uri);
        AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                //图片地址
                .setUri(URL_)
                //播放gif 图片
                .setAutoPlayAnimations(true)
                //点击重新加载时 可以重新加载4 次
                .setTapToRetryEnabled(true)
                .build();
        mSimpleDraweeView.setController(controller);
    }
    //高斯模糊
    /*public  void showUrlBlur(SimpleDraweeView draweeView, String url, int iterations, int blurRadius) {
        try {
            Uri uri = Uri.parse(url);
            ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                    .setPostprocessor(new IterativeBoxBlurPostProcessor(iterations, blurRadius))
                    .build();
            AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                    .setOldController(draweeView.getController())
                    .setImageRequest(request)
                    .build();
            draweeView.setController(controller);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
