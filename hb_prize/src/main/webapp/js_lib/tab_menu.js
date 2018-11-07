

		function appendPageByUrl(href,el,title){
			var uniqueIFrameId2017=new Date().getTime();
			/*$(this).click(function(){
				addIframeFromSub(this,href);							
			});*/
			
				var currEl = el;
			    var o = href,
			    m = uniqueIFrameId2017,
			    l = title,
			    k = true;
			    
			    $(currEl).addClass('J_menuItem').attr('data-index','m');
			    if (o == undefined || $.trim(o).length == 0) {
			        return false
			    }//  o������ҳ��url��m��index��l��text
			    $(".J_menuTab",parent.document).each(function() {//.J_menuTab �Ҳ�-����ر���
			        if ($(this).data("id") == o) {// �ж��Ҳ����������Ƿ���˶�Ӧ��iframe
			            if (!$(this).hasClass("active")) {// �Ҳ�-����ر���-ѡ��
			                $(this).addClass("active").siblings(".J_menuTab").removeClass("active");
			       
			                $(".J_mainContent .J_iframe",parent.document).each(function() {// �Ҳ�-������������ʾ��Ӧ��iframe������iframe��hide
			                    if ($(this).data("id") == o) {
			                        $(this).show().siblings(".J_iframe").hide();
			                        return false
			                    }
			                })
			            }
			            k = false;
			            return false
			        }
			    });
			    if (k) {
			        var p = '<a href="javascript:;" class="active J_menuTab" data-id="' + o + '">' + l + ' <i class="fa fa-times-circle"></i></a>';
			        $(".J_menuTab",parent.document).removeClass("active");
			        var n = '<iframe class="J_iframe" name="iframe' + m + '" width="100%" height="100%" src="' + o + '" frameborder="0" data-id="' + o + '" seamless></iframe>';
			        $(".J_mainContent",parent.document).find("iframe.J_iframe").hide().parents(".J_mainContent").append(n);
			        $(".J_menuTabs .page-tabs-content",parent.document).append(p);
			        // parent.g($(".J_menuTab.active",parent.document));
			        // g($(".J_menuTab.active",parent.document))
			    }
			    return false
			
		}
		
	
	