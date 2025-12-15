import { ArrowUpRight, ArrowDownRight, DollarSign, ShoppingCart, Activity, CreditCard } from 'lucide-react';

const summaryData = [
  {
    title: 'Total Sales',
    value: '$45,231.89',
    change: '+20.1%',
    trend: 'up',
    icon: DollarSign,
    description: 'from last month',
  },
  {
    title: 'Orders',
    value: '2,345',
    change: '+12.3%',
    trend: 'up',
    icon: ShoppingCart,
    description: 'from last month',
  },
  {
    title: 'Active Sessions',
    value: '1,234',
    change: '-4.7%',
    trend: 'down',
    icon: Activity,
    description: 'from last hour',
  },
  {
    title: 'Processing',
    value: '$12,234',
    change: '+8.1%',
    trend: 'up',
    icon: CreditCard,
    description: 'pending payments',
  },
];

export function SummaryCards() {
  return (
    <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-4">
      {summaryData.map((card, index) => {
        const Icon = card.icon;
        const isPositive = card.trend === 'up';
        
        return (
          <div key={index} className="bg-white rounded-xl shadow-sm border border-gray-200 p-6 hover:shadow-md transition-shadow">
            <div className="flex items-center justify-between mb-4">
              <div className="w-12 h-12 bg-gray-100 rounded-lg flex items-center justify-center">
                <Icon className="w-6 h-6 text-gray-700" />
              </div>
              <div className={`flex items-center gap-1 px-2 py-1 rounded-full ${
                isPositive ? 'bg-green-50 text-green-700' : 'bg-red-50 text-red-700'
              }`}>
                {isPositive ? (
                  <ArrowUpRight className="w-4 h-4" />
                ) : (
                  <ArrowDownRight className="w-4 h-4" />
                )}
                <span>{card.change}</span>
              </div>
            </div>
            <div>
              <p className="text-gray-600 mb-1">{card.title}</p>
              <p className="text-gray-900 mb-1">{card.value}</p>
              <p className="text-gray-500">{card.description}</p>
            </div>
          </div>
        );
      })}
    </div>
  );
}
