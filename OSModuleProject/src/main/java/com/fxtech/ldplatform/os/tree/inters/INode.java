package com.fxtech.ldplatform.os.tree.inters;

import java.util.List;

/**
 * 树节点接口，用来生成树菜单
 *
 * @author Ajaxfan
 */
public interface INode {
	/**
	 * 添加子节点
	 *
	 * @param node
	 */
	public void addChild(INode node);

	/**
	 * 子节点列表
	 *
	 * @return
	 */
	public List<INode> getChildren();

	/**
	 * 节点文本
	 * 
	 * @return
	 */
	public String getText();
}
