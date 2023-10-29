<script>
    import { Route } from "svelte-routing";
	import About from "../routes/About.svelte";
    import Home from "../routes/Home.svelte";
	import Library from './../routes/Library.svelte';
    import News from "../routes/News.svelte";
    import SearchSite from "../routes/SearchSite.svelte";
    import Projects from "../routes/Projects.svelte";
</script>

<div class="h-screen">
    <Route path="/" component={Home} />
    <Route path="/about-us" component={About} />
    <Route path="/library" component={Library} />
    <Route path="/news" component={News} />
    <Route path="/projects" component={Projects} />
    <Route path="/search-site" component={SearchSite} />
</div>