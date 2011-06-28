/**
 * Copyright (c)2010-2011 Enterprise Website Content Management System(EWCMS), All rights reserved.
 * EWCMS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * http://www.ewcms.com
 */

package com.ewcms.generator.freemarker.directive.page;

import org.apache.commons.lang.StringUtils;

/**
 * "下一页"跳转
 * 
 * @author wangwei
 */
class SkipPageNext implements SkipPageable<PageOut>{

    private static final String DEFAULT_LABEL="下一页";

    @Override
    public PageOut skip(Integer count,Integer number,String label,String url) {
       if(StringUtils.isBlank(label)){
           label = DEFAULT_LABEL;
       }
       int next = number + 1;
       if(next > (count-1)){
           url = null;
           next = count -1;
       }
       
       return new PageOut(count,next,label,url);
    }
}