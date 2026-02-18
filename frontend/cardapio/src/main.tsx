import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'
import { QueryClient, QueryClientProvider } from '@tanstack/react-query'
import React from 'react'

//configuração do react query
//ele guarda os dados(cache) buscados da API
//configuraçoes globais de querys, estado de fetch.

// O QueryClient centraliza e gerencia todas as queries da aplicação, permitindo cache inteligente,
// compartilhamento de dados entre componentes, configuração de comportamentos padrão (como retries e staleTime)
// e evitando requisições desnecessárias à API.

const queryClient = new QueryClient();

//declara a criação da conexão do react com o HTML
createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <QueryClientProvider client={queryClient}>
      <App />
    </QueryClientProvider>
  </React.StrictMode>,
)
