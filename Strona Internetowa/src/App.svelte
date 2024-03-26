<script>
	import { Router } from "svelte-routing";
	import Content from './lib/sections/Content.svelte';
	export let url = "";
</script>

<main class="">
	<Router {url}>
		<Content />
	</Router>
</main>
