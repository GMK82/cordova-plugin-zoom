#import <Cordova/CDV.h>

#import "CDVWKWebViewUIDelegate.h"
/*
@interface TerminateBrowserViewController : UIViewController
<CDVScreenOrientationDelegate,WKNavigationDelegate,WKUIDelegate,WKScriptMessageHandler>{
//<WKUIDelegate,WKScriptMessageHandler>{
    @private
    //CDVInAppBrowserOptions *_browserOptions;
    NSDictionary *_settings;
}

@property (nonatomic, strong) IBOutlet WKWebView* webView;

@end
*/

@interface ZoomControl : CDVPlugin <UIScrollViewDelegate>//<UIScrollViewDelegate, WKNavigationDelegate>//CDVPlugin
  //@property (nonatomic, retain) TerminateBrowserViewController* TerminateBrowserViewController;
- (void)zoomControl:(CDVInvokedUrlCommand *)command;

@end
