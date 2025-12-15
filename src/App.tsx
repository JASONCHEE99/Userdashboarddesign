import { Navigation } from './components/Navigation';
import { HeroPanel } from './components/HeroPanel';
import { SummaryCards } from './components/SummaryCards';
import { DataTable } from './components/DataTable';
import { tableData } from './data/tableData';

export default function App() {
  return (
    <div className="min-h-screen bg-gray-50">
      <Navigation />
      <main className="pt-16">
        <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-8 space-y-6">
          <HeroPanel />
          <SummaryCards />
          <DataTable data={tableData} />
        </div>
      </main>
    </div>
  );
}