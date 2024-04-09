<script>
	import { onMount } from "svelte";

	export let data;

	let ranks = [];

	// --- Fetching Rank Data ---
	async function fetchRankData() {
		try {
			const response = await fetch(`${import.meta.env.VITE_DB_URL}ranks`);
			ranks = await response.json();
			console.log(ranks);
		} catch (error) {
			console.error("Error fetching rank data:", error.message);
		}
	}

	onMount(fetchRankData);
</script>

<div>
	{#if ranks.length > 0}
		<h2>Ranki</h2>
		<ul>
			{#each ranks as rank}
				{#if rank.name !== null}
					<label class="block text-white">
						<input type="checkbox" class="mr-2" value={rank.id} on:change={()=>{}} />
						{rank.name}
					</label>
				{/if}
			{/each}
		</ul>
	{:else}
		<p class="text-white">Nie udało się załadować Stopni Wojskowych.</p>
	{/if}
</div>
