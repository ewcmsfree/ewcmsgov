/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ewcms.plugin.onlineoffice.web.advisor;

import com.ewcms.common.lang.EmptyUtil;
import com.ewcms.common.query.Resultable;
import com.ewcms.common.query.jpa.EntityQueryable;
import com.ewcms.common.query.jpa.QueryFactory;
import com.ewcms.plugin.interaction.model.Interaction;
import com.ewcms.plugin.onlineoffice.model.Advisor;
import com.ewcms.web.QueryBaseAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/**
 *
 * @author wangwei
 */
@Controller
public class AdvisorQueryAction extends QueryBaseAction {
    private int replay;
    private String title;
    private String content;

    public void setReplay(int replay) {
        this.replay = replay;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

	@Override
	protected Resultable queryResult(QueryFactory queryFactory,
			String cacheKey, int rows, int page, Order order) {
		EntityQueryable query = queryFactory.createEntityQuery(Interaction.class).setPage(page).setRow(rows);
        if (replay != 0) {
            if (replay == 1) {
                query.eq("state", 1);
            } else {
                query.eq("state", 0);
            }
        }

        if (EmptyUtil.isStringNotEmpty(title)) {
            query.likeAnywhere("title", title);
        }

        if (EmptyUtil.isStringNotEmpty(content)) {
            query.likeAnywhere("content", content);
        }

        query.orderDesc("date");		
        return query.queryCacheResult(cacheKey);
	}

	@Override
	protected Resultable querySelectionsResult(QueryFactory queryFactory,
			int rows, int page, String[] selections, Order order) {
		// TODO Auto-generated method stub
		return null;
	}
}
