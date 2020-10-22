#import "ZoomControl.h"


#import <WebKit/WebKit.h>
//@import WebKit;


//import UIKit
//import WebKit

#define  TA_BRIDGE_NAME @"cordova_ta"

@implementation ZoomControl

/*
- (void) disableScroll:(CDVInvokedUrlCommand*)command {
    if (!command.arguments || ![command.arguments count]){
      return;
    }
    id value = [command.arguments objectAtIndex:0];
    if (value != [NSNull null]) {
      self.disableScroll = [value boolValue];
    }
}
*/

- (void)zoomControl:(CDVInvokedUrlCommand *)command {
  //exit(0);
  //self.webView.scrollView.scrollEnabled = NO;
  //self.webView.contentMode = UIViewContentModeScaleToFill;
  
  
  self.webView.scrollView.scrollEnabled = true; //добавляет скрол для zoom режима
  self.webView.scrollView.bounces = false; //выход за пределы границ
  
  //self.webView.scrollView.zoomScale = 0.1;
  //self.webView.scrollView.bouncesZoom
  
  self.webView.scrollView.delegate = self; //включает zoom жестов в любой точке

  
  
  
  
  //self.webView.allowsBackForwardNavigationGestures = NO;
  //self.webView.contentMode = UIViewContentModeScaleToFill; //UIViewContentModeScaleAspectFit
  
  //self.webView.transform = CGAffineTransformScale(self.webView.transform, 0.5, 0.5);
  
  
  //self.webView.navigationDelegate = self;
  
  /*
  
      self.webView.clearsContextBeforeDrawing = YES;
      self.webView.clipsToBounds = YES;
      self.webView.contentMode = UIViewContentModeScaleToFill;
      self.webView.multipleTouchEnabled = YES;
      self.webView.opaque = YES;
      self.webView.userInteractionEnabled = YES;
      //self.automaticallyAdjustsScrollViewInsets = YES ;
      [self.webView setAutoresizingMask:UIViewAutoresizingFlexibleHeight | UIViewAutoresizingFlexibleWidth];
      //self.webView.allowsLinkPreview = NO;
      //self.webView.allowsBackForwardNavigationGestures = NO;
      
  #if __IPHONE_OS_VERSION_MAX_ALLOWED >= 110000
     if (@available(iOS 11.0, *)) {
         [self.webView.scrollView setContentInsetAdjustmentBehavior:UIScrollViewContentInsetAdjustmentNever];
     }
  #endif
  */
  
  /*
  NSString* js = @"var meta = document.createElement('meta');meta.setAttribute('name', 'viewport');meta.setAttribute('content', 'width=device-width, initial-scale=1.0, maximum-scale=10.0, user-scalable=yes');document.getElementsByTagName('head')[0].appendChild(meta);";
  
  
  [self evaluateJavaScript: js];
   */
}

- (void)evaluateJavaScript:(NSString *)jsScript {
    [self.webViewEngine evaluateJavaScript:jsScript completionHandler:^(id result, NSError *error) {
        if (error == nil) {
            if (result != nil) {
                NSLog(@"%@", result);
            }
        } else {
            NSLog(@"evaluateJavaScript error : %@ : %@", error.localizedDescription, jsScript);
        }
    }];
}


@end
