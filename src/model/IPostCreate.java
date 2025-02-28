package model;

public interface IPostCreate {
	//only public abstract functions are there
	public abstract void createPost(PostType postType, String ... params);

}
