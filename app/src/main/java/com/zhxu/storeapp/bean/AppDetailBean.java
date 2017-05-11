package com.zhxu.storeapp.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by xzhang on 2017/5/8.
 */

public class AppDetailBean extends ProtocalObj {


    /**
     * code : 200
     * downloadUrl : app/com.sina.weibo.1704272232/com.sina.weibo.1704272232.apk
     * msg : {"appIntro":{"appIntro":"","package":"com.sina.weibo"},"appLable":["博客","微博","新浪","社交","社区"],"info":{"appid":"C7166","developer":"新浪网技术（中国）有限公司","isExt":"0","releaseDate":"2017/4/28","size":"74724851","tariffDesc":"免费","version":"7.4.1"},"introduce":{"downloadNum":"12.8亿人次安装","iconUrl":"","labelNames":[{"name":"官方","type":0},{"name":"无广告","type":0},{"name":"无病毒","type":0},{"name":"人工复检","type":0}],"labels":["http://appimg.hicloud.com/hwmarket/files/appLabel/ccfcb74e8e0a46fa8a6be107eca45656_51H.png","http://appimg.hicloud.com/hwmarket/files/appLabel/novirus_51H.png","http://appimg.hicloud.com/hwmarket/files/appLabel/noad_51H.png"],"name":"微博","packageName":"app/com.sina.weibo.1704272232","safeLabels":[{"detectorDesc":"检测专员","detectorName":"华东","name":"人工复检 √","url":""},{"name":"华为安全检测 √","url":"http://appimg.hicloud.com/hwmarket/files/safe/hw.png"},{"name":"金山安全检测 √","url":"http://appimg.hicloud.com/hwmarket/files/safe/js.png"},{"name":"腾讯手机管家安全检测 √","url":"http://appimg.hicloud.com/hwmarket/files/safe/tx.png"}],"stars":5},"part":{"partPer":{"body":"","title":"权限"},"partRec":{"body":"看视频直播网红明星上微博","title":"小编推荐"},"partUpdate":{"body":"","title":"更新"}},"screen":{"imageCompress":["","","","",""],"images":["","","","http://appimg.hicloud.com/hwmarket/files/application/screenshut4/d25f3355cd5f4c8cacb7748376fc93c7.jpg","http://appimg.hicloud.com/hwmarket/files/application/screenshut5/d25f3355cd5f4c8cacb7748376fc93c7.jpg"]}}
     * tabInfo : [{"tabDetail":"应用详情介绍","tabId":"introduce","tabName":"介绍"},{"tabDetail":"应用详情评论","tabId":"comment","tabName":"评论149764"},{"tabDetail":"应用详情推荐","tabId":"recommend","tabName":"推荐"}]
     */

    private int code;
    private String downloadUrl;
    private MsgBean msg;
    private List<TabInfoBean> tabInfo;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public MsgBean getMsg() {
        return msg;
    }

    public void setMsg(MsgBean msg) {
        this.msg = msg;
    }

    public List<TabInfoBean> getTabInfo() {
        return tabInfo;
    }

    public void setTabInfo(List<TabInfoBean> tabInfo) {
        this.tabInfo = tabInfo;
    }

    public static class MsgBean {
        /**
         * appIntro : {"appIntro":"","package":"com.sina.weibo"}
         * appLable : ["博客","微博","新浪","社交","社区"]
         * info : {"appid":"C7166","developer":"新浪网技术（中国）有限公司","isExt":"0","releaseDate":"2017/4/28","size":"74724851","tariffDesc":"免费","version":"7.4.1"}
         * introduce : {"downloadNum":"12.8亿人次安装","iconUrl":"","labelNames":[{"name":"官方","type":0},{"name":"无广告","type":0},{"name":"无病毒","type":0},{"name":"人工复检","type":0}],"labels":["http://appimg.hicloud.com/hwmarket/files/appLabel/ccfcb74e8e0a46fa8a6be107eca45656_51H.png","http://appimg.hicloud.com/hwmarket/files/appLabel/novirus_51H.png","http://appimg.hicloud.com/hwmarket/files/appLabel/noad_51H.png"],"name":"微博","packageName":"app/com.sina.weibo.1704272232","safeLabels":[{"detectorDesc":"检测专员","detectorName":"华东","name":"人工复检 √","url":""},{"name":"华为安全检测 √","url":"http://appimg.hicloud.com/hwmarket/files/safe/hw.png"},{"name":"金山安全检测 √","url":"http://appimg.hicloud.com/hwmarket/files/safe/js.png"},{"name":"腾讯手机管家安全检测 √","url":"http://appimg.hicloud.com/hwmarket/files/safe/tx.png"}],"stars":5}
         * part : {"partPer":{"body":"","title":"权限"},"partRec":{"body":"看视频直播网红明星上微博","title":"小编推荐"},"partUpdate":{"body":"","title":"更新"}}
         * screen : {"imageCompress":["","","","",""],"images":["","","","http://appimg.hicloud.com/hwmarket/files/application/screenshut4/d25f3355cd5f4c8cacb7748376fc93c7.jpg","http://appimg.hicloud.com/hwmarket/files/application/screenshut5/d25f3355cd5f4c8cacb7748376fc93c7.jpg"]}
         */

        private AppIntroBean appIntro;
        private InfoBean info;
        private IntroduceBean introduce;
        private PartBean part;
        private ScreenBean screen;
        private List<String> appLable;

        public AppIntroBean getAppIntro() {
            return appIntro;
        }

        public void setAppIntro(AppIntroBean appIntro) {
            this.appIntro = appIntro;
        }

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public IntroduceBean getIntroduce() {
            return introduce;
        }

        public void setIntroduce(IntroduceBean introduce) {
            this.introduce = introduce;
        }

        public PartBean getPart() {
            return part;
        }

        public void setPart(PartBean part) {
            this.part = part;
        }

        public ScreenBean getScreen() {
            return screen;
        }

        public void setScreen(ScreenBean screen) {
            this.screen = screen;
        }

        public List<String> getAppLable() {
            return appLable;
        }

        public void setAppLable(List<String> appLable) {
            this.appLable = appLable;
        }

        public static class AppIntroBean {
            /**
             * appIntro :
             * package : com.sina.weibo
             */

            private String appIntro;
            @SerializedName("package")
            private String packageX;

            public String getAppIntro() {
                return appIntro;
            }

            public void setAppIntro(String appIntro) {
                this.appIntro = appIntro;
            }

            public String getPackageX() {
                return packageX;
            }

            public void setPackageX(String packageX) {
                this.packageX = packageX;
            }
        }

        public static class InfoBean {
            /**
             * appid : C7166
             * developer : 新浪网技术（中国）有限公司
             * isExt : 0
             * releaseDate : 2017/4/28
             * size : 74724851
             * tariffDesc : 免费
             * version : 7.4.1
             */

            private String appid;
            private String developer;
            private String isExt;
            private String releaseDate;
            private String size;
            private String tariffDesc;
            private String version;

            public String getAppid() {
                return appid;
            }

            public void setAppid(String appid) {
                this.appid = appid;
            }

            public String getDeveloper() {
                return developer;
            }

            public void setDeveloper(String developer) {
                this.developer = developer;
            }

            public String getIsExt() {
                return isExt;
            }

            public void setIsExt(String isExt) {
                this.isExt = isExt;
            }

            public String getReleaseDate() {
                return releaseDate;
            }

            public void setReleaseDate(String releaseDate) {
                this.releaseDate = releaseDate;
            }

            public String getSize() {
                return size;
            }

            public void setSize(String size) {
                this.size = size;
            }

            public String getTariffDesc() {
                return tariffDesc;
            }

            public void setTariffDesc(String tariffDesc) {
                this.tariffDesc = tariffDesc;
            }

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }
        }

        public static class IntroduceBean {
            /**
             * downloadNum : 12.8亿人次安装
             * iconUrl :
             * labelNames : [{"name":"官方","type":0},{"name":"无广告","type":0},{"name":"无病毒","type":0},{"name":"人工复检","type":0}]
             * labels : ["http://appimg.hicloud.com/hwmarket/files/appLabel/ccfcb74e8e0a46fa8a6be107eca45656_51H.png","http://appimg.hicloud.com/hwmarket/files/appLabel/novirus_51H.png","http://appimg.hicloud.com/hwmarket/files/appLabel/noad_51H.png"]
             * name : 微博
             * packageName : app/com.sina.weibo.1704272232
             * safeLabels : [{"detectorDesc":"检测专员","detectorName":"华东","name":"人工复检 √","url":""},{"name":"华为安全检测 √","url":"http://appimg.hicloud.com/hwmarket/files/safe/hw.png"},{"name":"金山安全检测 √","url":"http://appimg.hicloud.com/hwmarket/files/safe/js.png"},{"name":"腾讯手机管家安全检测 √","url":"http://appimg.hicloud.com/hwmarket/files/safe/tx.png"}]
             * stars : 5
             */

            private String downloadNum;
            private String iconUrl;
            private String name;
            private String packageName;
            private int stars;
            private List<LabelNamesBean> labelNames;
            private List<String> labels;
            private List<SafeLabelsBean> safeLabels;

            public String getDownloadNum() {
                return downloadNum;
            }

            public void setDownloadNum(String downloadNum) {
                this.downloadNum = downloadNum;
            }

            public String getIconUrl() {
                return iconUrl;
            }

            public void setIconUrl(String iconUrl) {
                this.iconUrl = iconUrl;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPackageName() {
                return packageName;
            }

            public void setPackageName(String packageName) {
                this.packageName = packageName;
            }

            public int getStars() {
                return stars;
            }

            public void setStars(int stars) {
                this.stars = stars;
            }

            public List<LabelNamesBean> getLabelNames() {
                return labelNames;
            }

            public void setLabelNames(List<LabelNamesBean> labelNames) {
                this.labelNames = labelNames;
            }

            public List<String> getLabels() {
                return labels;
            }

            public void setLabels(List<String> labels) {
                this.labels = labels;
            }

            public List<SafeLabelsBean> getSafeLabels() {
                return safeLabels;
            }

            public void setSafeLabels(List<SafeLabelsBean> safeLabels) {
                this.safeLabels = safeLabels;
            }

            public static class LabelNamesBean {
                /**
                 * name : 官方
                 * type : 0
                 */

                private String name;
                private int type;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }
            }

            public static class SafeLabelsBean {
                /**
                 * detectorDesc : 检测专员
                 * detectorName : 华东
                 * name : 人工复检 √
                 * url :
                 */

                private String detectorDesc;
                private String detectorName;
                private String name;
                private String url;

                public String getDetectorDesc() {
                    return detectorDesc;
                }

                public void setDetectorDesc(String detectorDesc) {
                    this.detectorDesc = detectorDesc;
                }

                public String getDetectorName() {
                    return detectorName;
                }

                public void setDetectorName(String detectorName) {
                    this.detectorName = detectorName;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }

        public static class PartBean {
            /**
             * partPer : {"body":"","title":"权限"}
             * partRec : {"body":"看视频直播网红明星上微博","title":"小编推荐"}
             * partUpdate : {"body":"","title":"更新"}
             */

            private PartPerBean partPer;
            private PartRecBean partRec;
            private PartUpdateBean partUpdate;

            public PartPerBean getPartPer() {
                return partPer;
            }

            public void setPartPer(PartPerBean partPer) {
                this.partPer = partPer;
            }

            public PartRecBean getPartRec() {
                return partRec;
            }

            public void setPartRec(PartRecBean partRec) {
                this.partRec = partRec;
            }

            public PartUpdateBean getPartUpdate() {
                return partUpdate;
            }

            public void setPartUpdate(PartUpdateBean partUpdate) {
                this.partUpdate = partUpdate;
            }

            public static class PartPerBean {
                /**
                 * body :
                 * title : 权限
                 */

                private String body;
                private String title;

                public String getBody() {
                    return body;
                }

                public void setBody(String body) {
                    this.body = body;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }

            public static class PartRecBean {
                /**
                 * body : 看视频直播网红明星上微博
                 * title : 小编推荐
                 */

                private String body;
                private String title;

                public String getBody() {
                    return body;
                }

                public void setBody(String body) {
                    this.body = body;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }

            public static class PartUpdateBean {
                /**
                 * body :
                 * title : 更新
                 */

                private String body;
                private String title;

                public String getBody() {
                    return body;
                }

                public void setBody(String body) {
                    this.body = body;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }
        }

        public static class ScreenBean {
            private List<String> imageCompress;
            private List<String> images;

            public List<String> getImageCompress() {
                return imageCompress;
            }

            public void setImageCompress(List<String> imageCompress) {
                this.imageCompress = imageCompress;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }
        }
    }

    public static class TabInfoBean {
        /**
         * tabDetail : 应用详情介绍
         * tabId : introduce
         * tabName : 介绍
         */

        private String tabDetail;
        private String tabId;
        private String tabName;

        public String getTabDetail() {
            return tabDetail;
        }

        public void setTabDetail(String tabDetail) {
            this.tabDetail = tabDetail;
        }

        public String getTabId() {
            return tabId;
        }

        public void setTabId(String tabId) {
            this.tabId = tabId;
        }

        public String getTabName() {
            return tabName;
        }

        public void setTabName(String tabName) {
            this.tabName = tabName;
        }
    }
}
