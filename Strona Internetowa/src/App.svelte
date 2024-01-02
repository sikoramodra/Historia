<script>
	import { Router } from "svelte-routing";
	import Content from './lib/Content.svelte';
	export let url = "";
</script>

<main class="bg-slate-950">
	<Router {url}>
		<Content />
	</Router>
</main>
