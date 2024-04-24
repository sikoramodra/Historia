<script>
	import { onMount } from "svelte";

	export let data;

	let ranks = [];

	// --- Fetching Rank Data ---
	async function fetchRankData() {
		try {
			const response = await fetch(`${import.meta.env.VITE_DB_URL}ranks`);
			ranks = await response.json();
		} catch (error) {
			console.error("Error fetching rank data:", error.message);
		}
	}

	let addToData = (e, event) => {
		if (e.target.checked) {
			data.push(event);
		} else {
			data = data.filter((item) => item.id !== event.id);
		}
		data = [...data];
	};
	
	onMount(fetchRankData);
</script>

<div class="overflow-auto {ranks.length > 0 ? 'h-48' : ''}">
	{#if ranks.length > 0}
		<ul>
			{#each ranks as rank}
				{#if rank.name !== null}
					<label class="block text-white">
						<input type="checkbox" class="mr-2" value={rank.id} on:change={(e) => addToData(e, rank)} />
						{rank.name}
					</label>
				{/if}
			{/each}
		</ul>
	{:else}
		<p class="text-white">Nie udało się załadować Stopni Wojskowych.</p>
	{/if}
</div>

<style>
	::-webkit-scrollbar {
		width: 12px;
	}

	::-webkit-scrollbar-track {
		background-color: transparent; /* Change the background color of the track */
        margin: 1px;
	}

	::-webkit-scrollbar-thumb {
		background-color: rgb(107 114 128); /* Change the color of the scrollbar thumb */
		border-radius: 20px; /* Add rounded corners to the scrollbar thumb */
	}

	::-webkit-scrollbar-thumb:active {
		background-color: rgb(51 65 85); /* Change the color on hover */
	}
</style>
