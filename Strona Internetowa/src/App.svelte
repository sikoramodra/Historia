<script>
	import Footer from './lib/Footer.svelte';
	import { Router } from "svelte-routing";
	import Navbar from './lib/Navbar.svelte';
	import Content from './lib/Content.svelte';
	export let url = "";
</script>

<main class="bg-slate-950">
	<Router {url}>
		<Navbar />
		<Content />
		<Footer />
	</Router>
</main>
