<script>
	export let data;
	export let closePopup;
</script>

<!-- <div class="text-center h-[85%] w-[85%] bg-gray-800 bg rounded-xl overflow-auto p-1 shadow-lg relative m-4 cursor-default border border-white">
	<div class="bg-gray-900 bg-opacity-20 rounded-xl shadow-2xl shadow-gray-900 relative p-4">
		<button class="absolute top-4 right-4 text-white text-2xl focus:outline-none" on:click={closePopup}>
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-lg" viewBox="0 0 16 16">
				<path
					d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8z"
				/>
			</svg>
		</button>

		{#if data}
			<div class="rounded-lg max-w-min max-h-min p-4 px-8 m-auto mb-4">
				<h2 class="text-4xl font-bold text-white">{data.name}</h2>
			</div>
			<div class="grid grid-cols-1 md:grid-cols-2 gap-y-6 md:gap-x-8 divide-y text-xl capitalize">
				<div class="pb-4 pt-2 rounded-lg border-t border-white border-opacity-90">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Epitafium:</p>
					<p class=" text-gray-400">{data.inscription || "Brak Danych..."}</p>
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Alternatywne Imiona i Nazwiska:</p>
					<p class=" text-gray-400">{data.other_names.join(", ") || "Brak Danych..."}</p>
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Pseudonimy:</p>
					<p class=" text-gray-400">{data.code_names.join(", ") || "Brak Danych..."}</p>
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Data Urodzenia:</p>
					<p class=" text-gray-400">{data.birth_date || "Brak Danych..."}</p>
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Miejsce Urodzenia:</p>
					<p class=" text-gray-400">{data.birth_place || "Brak Danych..."}</p>
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Data Śmierci:</p>
					<p class=" text-gray-400">{data.death_date || "Brak Danych..."}</p>
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Miejsce Śmierci:</p>
					<p class=" text-gray-400">{data.death_place || "Brak Danych..."}</p>
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Stopień Wojskowy:</p>
					{#if data.ranks}
						{#each data.ranks as rank}
							<p class="text-gray-400">{rank}</p>
						{/each}
					{:else}
						<p class="text-gray-400">Brak Danych...</p>
					{/if}
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Odznaczenia:</p>
					{#if data.badges}
						{#each data.badges as badge}
							<p class=" text-gray-400">{badge.badge || ""}</p>
							{#each badge.sub_badges as subBadge}
								<p class=" text-gray-400 ml-4">{subBadge || ""}</p>
							{/each}
						{/each}
					{:else}
						<p class="text-gray-400">Brak Danych...</p>
					{/if}
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Wydarzenia:</p>
					{#if data.activity}
						{#each data.activity as activity}
							<div class="ml-4 border-l-4 border-gray-300 pr-4 mb-8 divide-y my-4 border-double">
								<p class="text-xl font-semibold text-gray-400 mb-2">{activity.name}</p>
								{#each activity.sub_activity as subActivity}
									<div class="ml-4 border-l-4 border-gray-400 border-double pr-4 py-4">
										<p class="text-lg font-semibold text-gray-300 mb-2 mx-16 border-b">{subActivity.name}:</p>
										{#each subActivity.events as event}
											<p class="text-base text-gray-400 mr-4 underline-offset-4 underline">{event}</p>
										{/each}
									</div>
								{/each}
							</div>
						{/each}
					{:else}
						<p class="text-gray-400">Brak Danych...</p>
					{/if}
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Opis:</p>
					<p class=" text-gray-400">{data.description || "Brak Danych..."}</p>
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Źródła:</p>
					<p class=" text-gray-400">{data.sources || "Brak Danych..."}</p>
				</div>
			</div>
		{:else}
			<p class="text-xl font-semibold text-white">Nie wybrano osoby</p>
		{/if}
	</div>
</div> -->

<div class="text-center h-[85%] w-[85%] bg-gray-800 bg rounded-xl overflow-auto p-1 shadow-lg relative m-4 cursor-default border border-white">
	<div class="bg-gray-900 bg-opacity-20 rounded-xl shadow-2xl shadow-gray-900 relative p-4">
		<button class="absolute top-4 right-4 text-white text-2xl focus:outline-none" on:click={closePopup}>
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-lg" viewBox="0 0 16 16">
				<path
					d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8z"
				/>
			</svg>
		</button>

		{#if data}
			<div class="rounded-lg max-w-min max-h-min p-4 px-8 m-auto mb-4">
				<h2 class="text-4xl font-bold text-white">{data.name}</h2>
			</div>
			<div>
				<p class=" text-gray-400">{data.other_names.join(", ")}</p>
				<p class=" text-gray-400">{data.code_names.join(", ") || ""}</p>
			</div>
			<div class="grid grid-cols-1 md:grid-cols-2 gap-y-6 md:gap-x-8 divide-y text-xl capitalize">
				<div class="pb-4 pt-2 rounded-lg border-t border-white border-opacity-90">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Epitafium:</p>
					<p class=" text-gray-400">{data.inscription || "Brak Danych..."}</p>
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Data Urodzenia:</p>
					<p class=" text-gray-400">{data.birth_date || "Brak Danych..."}</p>
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Miejsce Urodzenia:</p>
					<p class=" text-gray-400">{data.birth_place || "Brak Danych..."}</p>
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Data Śmierci:</p>
					<p class=" text-gray-400">{data.death_date || "Brak Danych..."}</p>
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Miejsce Śmierci:</p>
					<p class=" text-gray-400">{data.death_place || "Brak Danych..."}</p>
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Stopień Wojskowy:</p>
					{#if data.ranks}
						{#each data.ranks as rank}
							<p class="text-gray-400">{rank}</p>
						{/each}
					{:else}
						<p class="text-gray-400">Brak Danych...</p>
					{/if}
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Odznaczenia:</p>
					{#if data.badges}
						{#each data.badges as badge}
							<p class=" text-gray-400">{badge.badge || ""}</p>
							{#each badge.sub_badges as subBadge}
								<p class=" text-gray-400 ml-4">{subBadge || ""}</p>
							{/each}
						{/each}
					{:else}
						<p class="text-gray-400">Brak Danych...</p>
					{/if}
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Wydarzenia:</p>
					{#if data.activity}
						{#each data.activity as activity}
							<div class="ml-4 border-l-4 border-gray-300 pr-4 mb-8 divide-y my-4 border-double">
								<p class="text-xl font-semibold text-gray-400 mb-2">{activity.name}</p>
								{#each activity.sub_activity as subActivity}
									<div class="ml-4 border-l-4 border-gray-400 border-double pr-4 py-4">
										<p class="text-lg font-semibold text-gray-300 mb-2 mx-16 border-b">{subActivity.name}:</p>
										{#each subActivity.events as event}
											<p class="text-base text-gray-400 mr-4 underline-offset-4 underline">{event}</p>
										{/each}
									</div>
								{/each}
							</div>
						{/each}
					{:else}
						<p class="text-gray-400">Brak Danych...</p>
					{/if}
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Opis:</p>
					<p class=" text-gray-400">{data.description || "Brak Danych..."}</p>
				</div>

				<div class="pb-4 pt-2 rounded-lg">
					<p class="text-2xl font-semibold text-gray-300 mb-2">Źródła:</p>
					<p class=" text-gray-400">{data.sources || "Brak Danych..."}</p>
				</div>
			</div>
		{:else}
			<p class="text-xl font-semibold text-white">Nie wybrano osoby</p>
		{/if}
	</div>
</div>

<style>
	::-webkit-scrollbar {
		width: 12px;
	}

	::-webkit-scrollbar-track {
		background-color: transparent;
		border-radius: 32px;
	}

	::-webkit-scrollbar-thumb {
		box-shadow: inset 0 0 6px rgb(15, 23, 42);
		background-color: rgba(31, 41, 55, 0.55);
		border-radius: 0.7rem;
	}
</style>
