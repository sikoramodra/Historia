<script>
	import Counter from "./lib/Counter.svelte";
</script>

<main>
	<h1 class="font-black text-center text-3xl logo">Jesteśmy By Pamiętać</h1>

	<div class="text-center">
		<Counter />
	</div>

</main>

<style>
	.logo {
		height: 6em;
		padding: 1.5em;
		will-change: filter;
		transition: filter 300ms;
	}
	.logo:hover {
		filter: drop-shadow(0 0 2em #646cffaa);
	}
	/* .read-the-docs {
		color: #888;
	} */
</style>
