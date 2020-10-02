package com.gmk82.zoomcontrol;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;
import org.json.JSONArray;
import org.json.JSONException;

import android.os.Build;
import android.webkit.WebView;
import android.webkit.WebSettings;
import java.lang.reflect.Method;
import android.os.Build.VERSION;
/**
 * This class echoes a string called from JavaScript.
 */
public class ZoomControl extends CordovaPlugin {
  private int lastDefaultScale = 0;
  public void setZoomControlGoneX(WebSettings view ,Object[] args){
    Class classType = view.getClass();
    try {
      Class[] argsClass = new Class[args.length];

      for (int i = 0, j = args.length; i < j; i++) {
        argsClass[i] = args[i].getClass();
      }
      Method[] ms= classType.getMethods();
      for (int i = 0; i < ms.length; i++) {
        if(ms[i].getName().equals("setDisplayZoomControls")){
          try {
            ms[i].invoke(view, false);
          } catch (Exception e) {
            e.printStackTrace();
          }
          break;
        }
        //Log.e("test", ">>"+ms[i].getName());
      }

    }catch (Exception e) {
      e.printStackTrace();
    }

  }


  @Override
  public boolean execute(String action, final JSONArray args,
                         final CallbackContext callbackContext) throws JSONException {

    if ("zoomControl".equals(action)) {

      final WebView webView = (WebView)this.webView.getEngine().getView();

      cordova.getActivity().runOnUiThread(new Runnable() {

        public void run() {

          try {
            LOG.d("SetZoomControl", "executing SetZoomControl");
            boolean enabled=args.getBoolean(0);
            webView.getSettings().setBuiltInZoomControls(enabled);
            webView.getSettings().setSupportZoom(enabled);
            int sysVersion = Integer.parseInt(VERSION.SDK);
            if(VERSION.SDK_INT >= 11 && enabled) {
              setZoomControlGoneX(webView.getSettings(), new Object[]{false});
            }
            callbackContext.success("OK");
          } catch (Exception e) {
            LOG.e("SetZoomControl", "Error: " + e.getMessage());
            callbackContext.error("Error: " + e.getMessage());
          }

        }
      });
      return true;
    }

    if ("setBuiltInZoomControls".equals(action)) {
      final WebView webView = (WebView)this.webView.getEngine().getView();
      cordova.getActivity().runOnUiThread(new Runnable() {
        public void run() {
          try {
            boolean enabled=args.getBoolean(0);
            LOG.d("setBuiltInZoomControls", "executing setBuiltInZoomControls");
            webView.getSettings().setBuiltInZoomControls(enabled);
            callbackContext.success("OK");
          } catch (Exception e) {
            LOG.e("setBuiltInZoomControls", "Error: " + e.getMessage());
            callbackContext.error("Error: " + e.getMessage());
          }
        }
      });
      return true;
    }

    if ("setDisplayZoomControls".equals(action)) {
      final WebView webView = (WebView)this.webView.getEngine().getView();
      cordova.getActivity().runOnUiThread(new Runnable() {
        public void run() {
          try {
            boolean enabled=args.getBoolean(0);
            LOG.d("setDisplayZoomControls", "executing setDisplayZoomControls");
            webView.getSettings().setDisplayZoomControls(enabled);
            callbackContext.success("OK");
          } catch (Exception e) {
            LOG.e("setDisplayZoomControls", "Error: " + e.getMessage());
            callbackContext.error("Error: " + e.getMessage());
          }
        }
      });
      return true;
    }

      if ("setInitialScale".equals(action)) {
          final WebView webView = (WebView)this.webView.getEngine().getView();
          cordova.getActivity().runOnUiThread(new Runnable() {
              public void run() {
                  try {
                      LOG.d("setInitialScale", "executing setInitialScale");
                      int scaleInPercent=args.getInt(0);
                      if (scaleInPercent == 0) {
                        lastDefaultScale = (lastDefaultScale == 0) ? 100 : 0;
                        scaleInPercent = lastDefaultScale;
                        webView.getSettings().setLoadWithOverviewMode(true);
                        webView.getSettings().setUseWideViewPort(true);
                      }
                      webView.setInitialScale(scaleInPercent);
                      callbackContext.success("OK");
                  }
                  catch (Exception e) {
                    LOG.e("setInitialScale", "Error: " + e.getMessage());
                    callbackContext.error("Error: " + e.getMessage());
                  }
              }
          });
          return true;
      }

    return false;

  }
}