<script>
    import { Route } from "svelte-routing";
    import Home from "../routes/Home.svelte";
	import Library from './../routes/Library.svelte';
    import SearchSite from "../routes/SearchSite.svelte";
    import Projects from "../routes/Projects.svelte";
</script>

<div class="h-screen">
    <Route path="/" component={Home} />
    <Route path="/library" component={Library} />
    <Route path="/projects" component={Projects} />
    <Route path="/search-site" component={SearchSite} />
</div>