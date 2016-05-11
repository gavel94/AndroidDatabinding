## AndroidDatabinding
这是Android的Data Binding的一个demo，Data Binding库的作用很强大，这里是最简单直观的体现，完全撇去烦恼的findViewById，让我们更加专注是代码的逻辑。
## 两种加载视图的方式
*	activity中`ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.main_activity);`

*	需要一个view视图
	*	在fragment中 在onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)中`FragmentTestBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false);`通过`binding.getRoot()`返回一个view对象。
	
	*	从官方文档上可以看出来通过`DataBindingUtil.inflate(LayoutInflater inflater, int layoutId,
            @Nullable ViewGroup parent, boolean attachToParent)`需要一个布局加载器，通常我们可以通过`LayoutInflater inflater = LayoutInflater.from(this);`来获取到一个inflater对象，这里主要是针对我们使用listview或者popupWindow等需要一个视图对象来说的

##	 Data Binding的命名规范
*	 默认情况下，一个Binding类会基于layout文件的名称而产生，将其转换为Pascal case（译注：首字母大写的命名规范）并且添加“Binding”后缀。上述的layout文件是activity_main.xml，因此生成的类名是ActivityMainBinding。

*	 假设你的activity_main.xml文件中有个控件的id是main_fl,那么获取这个控件的方式就是binding,mainFl,他在自动命名的时候会自动将你的下划线取消，并将后面一个字母大写

## 这个demo中还包含了一个recyclerview的公共适配器，有兴趣的朋友可以自己看一下。毕竟这里的主角是我们的Data Binding。