<script>
    import { Route } from "svelte-routing";
    import Home from "../../routes/Home.svelte";
	// @ts-ignore
	import Library from '../../routes/Library.svelte';
    import SearchSite from "../../routes/SearchSite.svelte";
    import Projects from "../../routes/Projects.svelte";
	import AddPerson from '../../routes/AddPerson.svelte';
    import Post from '../../Post.svelte';
</script>

<div>
    <Route path="/" component={Home} />
    <Route path="/library" component={Library} />
    <Route path="/projects" component={Projects} />
    <Route path="/search-site" component={SearchSite} />
    <Route path="/add-person" component={AddPerson} />
    <Route path="/library/:articleId" component={Post} />
</div>